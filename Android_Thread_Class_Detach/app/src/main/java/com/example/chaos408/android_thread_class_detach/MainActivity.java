package com.example.chaos408.android_thread_class_detach;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    private int mainNum;
    private int secondNum;
    private TextView tvMain = null;
    private TextView tvSecond = null;
    private Button btnStart = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = (TextView) findViewById(R.id.tv_main_thread);
        tvSecond = (TextView) findViewById(R.id.tv_second_thread);
        btnStart = (Button) findViewById(R.id.bt_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNum();
            }
        });
    }

    Handler mainHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == NewThread.NEWTHREAD_WHAT) {
                secondNum = msg.arg1;
                tvSecond.setText("secondNum : " + secondNum);
                Log.i(TAG, "################ secondNum in handler : " + secondNum);
            }
        }
    };

    private void startNum() {
        mainNum++;
        tvMain.setText("mainNum : " + mainNum);

        NewThread newThread = new NewThread(mainHandler, secondNum);
        newThread.setDaemon(true);
        newThread.start();
    }


}
