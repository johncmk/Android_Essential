package com.example.chaos408.android_adapter_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList = null;
    ArrayAdapter<String> adapter = null;
    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList = new ArrayList<String>();
        arrayList.add("MON");
        arrayList.add("TUE");
        arrayList.add("WED");
        arrayList.add("THR");
        arrayList.add("FRI");
        arrayList.add("SAT");
        arrayList.add("SUN");

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, arrayList);

        listView = (ListView) findViewById(R.id.lv_01);
        listView.setAdapter(adapter);
    }
}
