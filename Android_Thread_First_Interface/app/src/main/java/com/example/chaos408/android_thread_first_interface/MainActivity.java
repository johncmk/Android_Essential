package com.example.chaos408.android_thread_first_interface;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mainNum = 0;
    private int secondNum = 0;
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

        btnStart.setOnClickListener(onClickListener);

    }//End onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.bt_start:
                    startNum();
                    break;
            }
        }
    };

    private void startNum() {
        mainNum++;

        SecondRunnable runnable = new SecondRunnable();
        Thread newThread = new Thread(runnable);
        newThread.setDaemon(true);
        newThread.start();

        tvMain.setText("mainNum : " + mainNum);
        tvSecond.setText("secondNum : " + secondNum);
    }

    //Inner Class
    class SecondRunnable implements Runnable {

        @Override
        public void run() {
            while(true) {
                secondNum++;
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}//End Class
