package com.example.chaos408.android_adapterview_listactivity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<String> data = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();
        data.add("MON");
        data.add("TUE");
        data.add("WED");
        data.add("THR");
        data.add("FRI");
        data.add("SAT");
        data.add("SUN");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        setListAdapter(adapter);
    }
}
