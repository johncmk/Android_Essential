package com.example.chaos408.android_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity", "################onCreate()################");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.i("MainActivity", "################onStart()################");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("MainActivity", "################onResume()################");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("MainActivity", "################onPause()################");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("MainActivity", "################onStop()################");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("MainActivity", "################onDestroy()################");
        super.onDestroy();
    }

}
