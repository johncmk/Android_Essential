package com.example.chaos408.android_intent_explicit_activity_communication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int USER_INFO = 0;

    TextView tv = null;
    Button btn_Go_Second = null;
    Button btn_Go_Third = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_main);
        btn_Go_Second = (Button) findViewById(R.id.bt_go_second);
        btn_Go_Third = (Button) findViewById(R.id.bt_go_third);

        btn_Go_Second.setOnClickListener(onClickListener);
        btn_Go_Third.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = null;

            switch (v.getId()) {
                case R.id.bt_go_second:
                    intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("u_id", "john");
                    intent.putExtra("u_pw", 1010);
                    startActivity(intent);
                    break;
                case R.id.bt_go_third:
                    intent = new Intent(MainActivity.this, ThirdActivity.class);
                    intent.putExtra("u_id", "john");
                    intent.putExtra("u_pw", 1010);
                    startActivityForResult(intent, MainActivity.USER_INFO);
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case MainActivity.USER_INFO:
                if(resultCode == ThirdActivity.LOG_IN_OK) {
                    tv.setText("Login Succeed!, " + data.getStringExtra("user_info"));
                } else {
                    tv.setText("Login Failed! ," + data.getStringExtra("user_info"));
                }
                break;
        }

        };
}//End
