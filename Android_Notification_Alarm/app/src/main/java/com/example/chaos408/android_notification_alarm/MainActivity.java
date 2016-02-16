package com.example.chaos408.android_notification_alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    Button btnOneAlarm = null;
    Button btnCycleAlarm = null;
    Button btnStopAlarm = null;

    AlarmManager alarmManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOneAlarm = (Button) findViewById(R.id.bt_start_one_alarm);
        btnCycleAlarm = (Button) findViewById(R.id.bt_alarm_repeat);
        btnStopAlarm = (Button) findViewById(R.id.bt_alarm_halt);

        btnOneAlarm.setOnClickListener(onClickListener);
        btnCycleAlarm.setOnClickListener(onClickListener);
        btnStopAlarm.setOnClickListener(onClickListener);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

    }//End onCrate

    private void Alarm_once() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("str", "Alarm once value");
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0 , intent, 0);

        alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 3000, pendingIntent);
    }

    private void Alarm_repeat() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("str", "repeat alarm value");
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis() + 3000, 5000, pendingIntent);

    }

    private void Alarm_halt() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        alarmManager.cancel(pendingIntent);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(TAG, "################ " + "onClick v.getID() : " + v.getId() + " ################");

            switch (v.getId()) {

                case R.id.bt_start_one_alarm:
                    Alarm_once();
                    break;

                case R.id.bt_alarm_repeat:
                    Alarm_repeat();
                    break;

                case R.id.bt_alarm_halt:
                    Alarm_halt();
                    break;
            }//End Switch
        }
    };
}//End Class
