package com.example.chaos408.android_notification_alarm;

import android.app.AlarmManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    AlarmManager alarmManager = null;
    Button btn_main = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("str");

        TextView tv_01 = (TextView) findViewById(R.id.tv_01);
        tv_01.setText(msg);

        btn_main = (Button) findViewById(R.id.back_main);
        btn_main.setOnClickListener(onClickListener);

    }//End onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.back_main:
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

}//End Class
