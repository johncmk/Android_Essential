package com.example.chaos408.android_notification_bar;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";
    final static int NOTI_ID = 50;

    Button btn_notification = null;
    NotificationManager notiManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_notification = (Button) findViewById(R.id.btn_notification);

        btn_notification.setOnClickListener(onClickListener);

        notiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


    }//End onCreate

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void notification_start() {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("str", "str_value");

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        Notification notification = new Notification.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.g02)
                .setTicker("Noti MSG")
                .setContentTitle("Noti Title")
                .setContentText("Noti Content")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .build();

        notiManager.notify(NOTI_ID, notification);

    }//End notification_start()

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Log.i(TAG, "############ " + "onClick v.getID() : " + v.getId() + " ############");

            switch (v.getId()) {
                case R.id.btn_notification:
                    notification_start();
                    break;
            }
        }
    };

}//End Class
