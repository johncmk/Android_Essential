package com.example.chaos408.android_thread_first_mainhandler_runnable;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    private int mainNum = 0;
    private int secondNum = 0;

    private TextView tvMain = null;
    private TextView tvSecond = null;
    private Button btnStart = null;

    private Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = (TextView) findViewById(R.id.tv_main_thread);
        tvSecond = (TextView) findViewById(R.id.tv_second_thread);

        btnStart  = (Button) findViewById(R.id.bt_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNum();
            }
        });
    }

    private void startNum() {
        mainNum++;

        NewThread newThread = new NewThread();
        newThread.setDaemon(true);
        newThread.start();

        tvMain.setText("mainNum : " + mainNum);
        tvSecond.setText("secondNum : " +secondNum);
    }


    //Inner Class
    class NewThread extends Thread {

        @Override
        public void run() {
            while(true) {
                secondNum++;
                Log.i(TAG, "################ secondNum in thread : " + secondNum);
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvSecond.setText("secondNum : " + secondNum);
                    }
                });
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
