package com.example.chaos408.android_broadcast_power;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        Intent intent = getIntent();
        String s = intent.getStringExtra("powerStatus");

        TextView textView = (TextView) findViewById(R.id.tv_result);
        textView.setText(s);
    }
}
