package com.example.chaos408.android_intent_explicit_activity_communication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv = null;
    Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = (TextView) findViewById(R.id.tv_second);
        btn = (Button) findViewById(R.id.bt_go_main);

        btn.setOnClickListener(onClickListener);

        Intent intent = getIntent();
        String u_id = intent.getStringExtra("u_id");
        int u_pw = intent.getIntExtra("u_pw", 0);

        tv.setText("u_id : " + u_id + ", u_pw : " + u_pw);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.bt_go_main:
                    finish();
                    break;
                default:
                    break;
            }
        }
    };

}//End Class
