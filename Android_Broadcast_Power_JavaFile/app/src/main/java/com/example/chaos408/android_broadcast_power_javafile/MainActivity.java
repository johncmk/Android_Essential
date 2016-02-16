package com.example.chaos408.android_broadcast_power_javafile;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.chaos408.android_broadcast_power_javafile.br.BrEx;

public class MainActivity extends AppCompatActivity {

    TextView tv01 = null;
    BrEx brEx = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01 = (TextView) findViewById(R.id.tv_01);
        brEx = new BrEx(tv01);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(brEx, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(brEx);
    }


}
