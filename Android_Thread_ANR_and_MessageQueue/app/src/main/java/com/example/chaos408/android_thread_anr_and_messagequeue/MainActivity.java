package com.example.chaos408.android_thread_anr_and_messagequeue;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final static int ALL_DELETE = 0;

    private Button btnDelete = null;
    private Button btn01 = null;
    private Button btn02 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDelete = (Button) findViewById(R.id.bt_delete);
        btn01 = (Button) findViewById(R.id.bt_01);
        btn02 = (Button) findViewById(R.id.bt_02);

        btnDelete.setOnClickListener(listener);
        btn01.setOnClickListener(listener);
        btn02.setOnClickListener(listener);

    }

    Handler handler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ALL_DELETE:
                    allDataDelete();
                    break;
            }
        }
    };

    private void allDataDelete() {
        Toast.makeText(MainActivity.this, "Delete Start", Toast.LENGTH_SHORT).show();

//        try {
//            Thread.sleep(10000);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }

        Toast.makeText(MainActivity.this, "Delete Complete", Toast.LENGTH_SHORT).show();

        Log.i(TAG, "################ allDataDelete() End");
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ) {
                case R.id.bt_delete:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Delete")
                            .setMessage("Would you like to delete all? \n This might take few min to finish process")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//                                    allDataDelete();
                                    Message msg = Message.obtain();
                                    msg.what = ALL_DELETE;
                                    handler.sendMessageDelayed(msg, 10000);
                                    Log.i(TAG, "################ onClick() End");
                                }
                            })
                            .setNegativeButton("Cancel", null)
                            .show();
                    break;

                case R.id.bt_01:
                    Toast.makeText(MainActivity.this, "Addition process execute", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.bt_02:
                    Toast.makeText(MainActivity.this, "Subtraction process execute", Toast.LENGTH_SHORT).show();
                    break;
            }//End switch
        }
    };


}
