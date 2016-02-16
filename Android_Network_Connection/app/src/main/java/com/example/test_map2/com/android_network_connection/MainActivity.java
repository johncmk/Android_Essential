package com.example.test_map2.com.android_network_connection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private String urlAddr = "http://www.sba.seoul.kr";
    private Button btnNetCon = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNetCon = (Button) findViewById(R.id.bt_network_con);

        btnNetCon.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ) {

                case R.id.bt_network_con:

                    NetWorkAsyncTask netWorkAsyncTask = new NetWorkAsyncTask(MainActivity.this, urlAddr);
                    netWorkAsyncTask.execute(100);

                    break;

            }//End
        }
    };
}
