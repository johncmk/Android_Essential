package com.example.test_map2.com.android_network_connection_json_parse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private String urlAddr = "http://blogstudy.zpat.info/json_members.txt";
//    private String urlAddr = "http://jsonparsing.parseapp.com/jsonData/moviesDemoItem.txt";
    private Button btnNetCon = null;
    private ListView listView = null;
    private ArrayList<Member> members = null;
    private MemberAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNetCon = (Button) findViewById(R.id.bt_network_con);
        btnNetCon.setOnClickListener(listener);
        listView = (ListView) findViewById(R.id.lv_members);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId())  {
                case R.id.bt_network_con:
                    try {
                        NetWorkAsyncTask netWorkAsyncTask = new NetWorkAsyncTask(MainActivity.this, urlAddr);
                        Object obj = netWorkAsyncTask.execute().get();
                        members = (ArrayList<Member>) obj;
                        Log.i(TAG, "#### members.size() : " + members.size());

                        adapter = new MemberAdapter(MainActivity.this, R.layout.custom_layout, members);
                        listView.setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
}
