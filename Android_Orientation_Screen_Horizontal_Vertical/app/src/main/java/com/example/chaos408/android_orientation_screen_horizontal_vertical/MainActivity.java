package com.example.chaos408.android_orientation_screen_horizontal_vertical;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("TAG", "onCreate()");
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.bt_go_second);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(v.getId()) {
                    case R.id.bt_go_second:
                        Intent i = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(i);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
