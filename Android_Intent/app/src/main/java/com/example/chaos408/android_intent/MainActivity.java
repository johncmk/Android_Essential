package com.example.chaos408.android_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("onCreate()", "################OnCreate()################");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.bt_go_second_activity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(v.getId()) {
                    case R.id.bt_go_second_activity:

                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });


    }

    @Override
    protected void onStart() {
        Log.i("onStart()", "################OnStart()################");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("onResume()", "################OnResume()################");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("onPause()", "################OnPause()################");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("onStop()", "################OnStop()################");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("onDestroy()", "################OnDestroy()################");
        super.onDestroy();
    }
}
