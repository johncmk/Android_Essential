package com.example.chaos408.android_notification_bar;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    NotificationManager notiManager = null;
    TextView tv_01 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notiManager.cancel(MainActivity.NOTI_ID);

        tv_01 = (TextView) findViewById(R.id.tv_01);
        Intent intent = getIntent();
        String noti_msg = intent.getStringExtra("str");
        tv_01.setText(noti_msg);

    }
}
