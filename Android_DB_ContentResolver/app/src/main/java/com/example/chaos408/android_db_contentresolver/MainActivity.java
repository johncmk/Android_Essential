package com.example.chaos408.android_db_contentresolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    private static final String AUTHORITY ="com.example.chaos408.android_db_contentprovider.MemberInfoProvider";
    private static final String PATH ="memberInfo"; // DB name
    private static final String UID = "john_resolver";

    private static Uri CONTENT_URI_MEMEBERS = Uri.parse("content://" + AUTHORITY + "/" + PATH);
    private static Uri CONTENT_URI_MEMEBER = Uri.parse("content://" + AUTHORITY + "/" + PATH + "/" + UID);

    ContentResolver cr = null;
    Button btnInsert, btnDelete, btnUpdate, btnSelectAll, btnSelectOne;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cr = getContentResolver();

        btnInsert = (Button) findViewById(R.id.bt_insert);
        btnDelete = (Button) findViewById(R.id.bt_delete);
        btnUpdate = (Button) findViewById(R.id.bt_update);
        btnSelectAll = (Button) findViewById(R.id.bt_select_all);
        btnSelectOne = (Button) findViewById(R.id.bt_select_one);
        tvResult = (TextView) findViewById(R.id.tv_result);

        btnInsert.setOnClickListener(listener);
        btnDelete.setOnClickListener(listener);
        btnUpdate.setOnClickListener(listener);
        btnSelectAll.setOnClickListener(listener);
        btnSelectOne.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.bt_insert:
                    try {
                        ContentValues values = new ContentValues();
                        values.put("uname", "John Resolver");
                        values.put("uid", "john_resolver");
                        values.put("upw", 789);

                        cr.insert(CONTENT_URI_MEMEBERS, values);
                        Toast.makeText(MainActivity.this, "INSERT OK!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "INSERT NG!", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.bt_delete:
                    try {
                        cr.delete(CONTENT_URI_MEMEBER, null, null);
                        Toast.makeText(MainActivity.this, "DELETE OK!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "DELETE NG!", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.bt_update:
                    try {
                        ContentValues values2 = new ContentValues();
                        values2.put("uname", "John Resolver Update");
                        cr.update(CONTENT_URI_MEMEBER, values2, null, null);
                        Toast.makeText(MainActivity.this, "UPDATE OK!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "UPDATE NG!", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.bt_select_all:
                    Cursor cursor = null;
                    try {
                        cursor = cr.query(CONTENT_URI_MEMEBERS, null, null, null, null);
                        StringBuffer sb = new StringBuffer();
                        while (cursor.moveToNext()) {
                            String uname = cursor.getString(0);
                            String uid = cursor.getString(1);
                            int upw = cursor.getInt(2);
                            sb.append("uname : " + uname + ", uid : " + uid + ", upw : " + upw + "\n");
                        }
                        tvResult.setText(sb.toString());
                        Toast.makeText(MainActivity.this, "SELECT_ALL OK!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "SELECT_ALL NG!", Toast.LENGTH_SHORT).show();
                    } finally {
                        try {
                            if(cursor != null) cursor.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    break;

                case R.id.bt_select_one:
                    Cursor cursor2 = null;
                    try {
                        cursor2 = cr.query(CONTENT_URI_MEMEBER, null, null, null, null);

                        StringBuffer sb = new StringBuffer();

//					while (cursor2.moveToNext()) {
//						String uname = cursor2.getString(0);
//						String uid = cursor2.getString(1);
//						int upw = cursor2.getInt(2);
//
//						sb.append("uname : " + uname + ", uid : " + uid + ", upw : " + upw + "\n");
//						Log.i(TAG, "sb : " + sb.toString());
//					}
//					tvResult.setText(sb.toString());
//					Toast.makeText(MainActivity.this, "SELECT_ONE OK!", Toast.LENGTH_SHORT).show();


                        if(cursor2.moveToFirst()) {
                            String uname = cursor2.getString(0);
                            String uid = cursor2.getString(1);
                            int upw = cursor2.getInt(2);
                            sb.append("uname : " + uname + ", uid : " + uid + ", upw : " + upw);
                            Log.i(TAG, "#### sb : " + sb.toString());
                        }
                        tvResult.setText(sb.toString());
                        Toast.makeText(MainActivity.this, "SELECT_ONE OK!", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "SELECT_ONE NG!", Toast.LENGTH_SHORT).show();
                    } finally {
                        try {
                            if(cursor2 != null) cursor2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    break;
            }//End switch
        }
    };
}
