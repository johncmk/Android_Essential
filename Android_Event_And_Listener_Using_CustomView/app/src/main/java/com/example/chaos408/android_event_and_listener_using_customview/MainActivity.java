package com.example.chaos408.android_event_and_listener_using_customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        CustomView customView = new CustomView(this);
        setContentView(customView);

    }
}
