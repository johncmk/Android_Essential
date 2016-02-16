package com.example.chaos408.android_adapter_view_xml;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<CharSequence> arrayAdapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.weather, android.R.layout.simple_expandable_list_item_1);

        listView = (ListView) findViewById(R.id.lv_01);
        listView.setAdapter(arrayAdapter);
        */

        //Check item
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.weather, android.R.layout.simple_list_item_checked);

        listView = (ListView) findViewById(R.id.lv_01);
        listView.setAdapter(arrayAdapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setDivider(new ColorDrawable(Color.GREEN));
        listView.setDividerHeight(3);
    }
}
