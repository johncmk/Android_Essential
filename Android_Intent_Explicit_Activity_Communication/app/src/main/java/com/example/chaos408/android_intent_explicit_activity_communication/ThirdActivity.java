package com.example.chaos408.android_intent_explicit_activity_communication;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chaos408.android_intent_explicit_activity_communication.log.Constant;

public class ThirdActivity extends AppCompatActivity {

    final static String TAG = "ThirdActivity";

    final static int LOG_IN_OK = 0;
    final static int LOG_IN_NG = 1;

    TextView tv = null;
    Button btn = null;

    boolean loginFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv = (TextView) findViewById(R.id.tv_third);
        btn = (Button) findViewById(R.id.bt_go_main);

        btn.setOnClickListener(onClickListener);

        //Declare intent to retrieve data that passed from MainActivity
        Intent intent = getIntent();

        String u_id = intent.getStringExtra("u_id");
        int u_pw = intent.getIntExtra("u_pw", 0);

        //Write log here
        if(Constant.DEBUG_MODE) {
            Log.i(TAG, "################ u_id : " + u_id);
            Log.i(TAG, "################ u_pw : " + u_pw);
        }
        //End log...


        tv.setText("u_id : " + u_id + ", u_pw : " + u_pw);

        loginFlag = (u_id.equals("john") && u_pw == 1010);

        //Write log here
        if(Constant.DEBUG_MODE) {
            Log.i(TAG, "################ loginFlag : " + loginFlag);
        }
        //End log...

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.bt_go_main:

                    Intent intent = new Intent();
                    intent.putExtra("user_info" , tv.getText().toString());
                    if(loginFlag) {
                        setResult(ThirdActivity.LOG_IN_OK, intent);
                    } else {
                        setResult(ThirdActivity.LOG_IN_NG, intent);
                    }
                    finish();
                    break;
            }
        }
    };

}
