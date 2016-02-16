package com.example.chaos408.android_db_contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    MemberInfoHelper memberInfoHelper;

    Button
            btnInsert,
            btnDelete,
            btnUpdate,
            btnSelect;

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memberInfoHelper = new MemberInfoHelper(this);

        btnInsert = (Button) findViewById(R.id.bt_insert);
        btnDelete = (Button) findViewById(R.id.bt_delete);
        btnUpdate = (Button) findViewById(R.id.bt_update);
        btnSelect = (Button) findViewById(R.id.bt_select);

        tvResult = (TextView) findViewById(R.id.tv_result);

        btnInsert.setOnClickListener(listener);
        btnDelete.setOnClickListener(listener);
        btnUpdate.setOnClickListener(listener);
        btnSelect.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {

        SQLiteDatabase db;
        ContentValues values = new ContentValues();

        @Override
        public void onClick(View v) {

            switch ( v.getId() ) {

                case R.id.bt_insert:
                    try {
                        //There are two alternative ways to send query to db
                        //use SQLite ORM else use general style query execution

                        //SQLite
                        db = memberInfoHelper.getWritableDatabase();
                        values.put("uname","John ORM");
                        values.put("uid", "john_orm");
                        values.put("upw", 1010);
                        db.insert("member", null, values);
                        //End SQLite

                        //General Style query execution
                        String query = "INSERT INTO member (_id, uname, uid, upw)" +
                                "VALUES(null, 'John SQL', 'john_sql', 1010)";
                        db.execSQL(query);
                        //End General Style query

                        memberInfoHelper.close();

                        Toast.makeText(MainActivity.this, "INSERT OK!", Toast.LENGTH_SHORT).show();

                    }catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "INSERT NG!", Toast.LENGTH_SHORT).show();
                    }

                    break;

                case R.id.bt_delete:
                    try {

                        db = memberInfoHelper.getWritableDatabase();

                        //SQLite way
//                        db.delete("member",null,null);

                        //General Style query execution
                        String query = "DELETE FROM member";
                        db.execSQL(query);

                        memberInfoHelper.close();
                        Toast.makeText(MainActivity.this, "DELETE OK", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "DELETE NG!", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.bt_update:
                    try {
                        db = memberInfoHelper.getWritableDatabase();

                        //SQLite way
                        values = new ContentValues();
//                        values.put("uname", "John Smith Updated");
//                        db.update("member", values, "uid='john_orm'",null);

                        //General Style query execution
                        String query = "UPDATE member SET uname = 'John SQL Updated' WHERE uid = 'john_sql'";
                        db.execSQL(query);

                        memberInfoHelper.close();
                        Toast.makeText(MainActivity.this, "UPDATE OK", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "UPDATE NG", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.bt_select:
                    try {

                        db = memberInfoHelper.getReadableDatabase();

//                        String[] columns = {"uname","uid","upw"};
//                        Cursor cursor = db.query("member", columns, null, null, null, null, null);

                        //General Style query
                        String query = "SELECT uname, uid, upw FROM member";
                        Cursor cursor = db.rawQuery(query,null);

                        StringBuffer sb = new StringBuffer();

                        while( cursor.moveToNext() ) {
                            String uname = cursor.getString(0);
                            String uid = cursor.getString(1);
                            int upw = cursor.getInt(2);

                            sb.append("uname : " + uname)
                                    .append(", uid : " + uid)
                                    .append(", upw : " + upw + "\n");

                        }

                        tvResult.setText(sb.toString());

                        memberInfoHelper.close();
                        Toast.makeText(MainActivity.this, "SELECT OK", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "SELECT NG", Toast.LENGTH_SHORT).show();
                    }
                    break;

            }//End switch


        }
    };
}
