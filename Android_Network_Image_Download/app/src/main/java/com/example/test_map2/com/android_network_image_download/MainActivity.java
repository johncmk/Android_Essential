package com.example.test_map2.com.android_network_image_download;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private String urlAddr = "http://www.sba.seoul.kr/kr/images/index/visual16.jpg";
    private Button btnNetCon = null;
    private ImageView ivNet = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNetCon = (Button) findViewById(R.id.bt_network_con);
        btnNetCon.setOnClickListener(listener);

        ivNet = (ImageView) findViewById(R.id.iv_network_img);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_network_con:
                    NetWorkAsyncTask netWorkAsyncTask = new NetWorkAsyncTask(MainActivity.this, ivNet, urlAddr);
                    netWorkAsyncTask.execute(100);
                    break;
            }//End Switch
        }
    };
}
