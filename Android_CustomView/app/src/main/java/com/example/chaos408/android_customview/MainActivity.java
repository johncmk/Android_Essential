package com.example.chaos408.android_customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomView customView = new CustomView(MainActivity.this);
        setContentView(customView);
    }
}
