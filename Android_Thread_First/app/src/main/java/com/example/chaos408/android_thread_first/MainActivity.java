package com.example.chaos408.android_thread_first;

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

    }//End onCrate

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

        NewThread newThread = new NewThread();
        newThread.setDaemon(true);
        newThread.start();

        tvMain.setText("mainNum : " + mainNum);
        tvSecond.setText("secondNum : " + secondNum);
    }

    class NewThread extends Thread{

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
        }//End run
    }//End inner class

}//End Class
