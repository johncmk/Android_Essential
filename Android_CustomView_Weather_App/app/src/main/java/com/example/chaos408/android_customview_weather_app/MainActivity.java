package com.example.chaos408.android_customview_weather_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Weather> data = null;
    private WeatherAdapter adapter = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<Weather>();
        data.add(new Weather("MON1", R.drawable.w_icon_01,"Sunny"));
        data.add(new Weather("TUE2", R.drawable.w_icon_02,"Cloudy"));
        data.add(new Weather("WED3", R.drawable.w_icon_03,"Cloudy/Rainy"));
        data.add(new Weather("THR4", R.drawable.w_icon_04,"Rainy"));
        data.add(new Weather("FRI5", R.drawable.w_icon_02, "Cloudy"));
        data.add(new Weather("SAT6", R.drawable.w_icon_01, "Sunny"));
        data.add(new Weather("SUN7", R.drawable.w_icon_03,"Cloudy/Rainy"));
        data.add(new Weather("MON8", R.drawable.w_icon_01,"Sunny"));
        data.add(new Weather("TUE9", R.drawable.w_icon_02,"Cloudy"));
        data.add(new Weather("WED10", R.drawable.w_icon_03,"Cloudy/Rainy"));
        data.add(new Weather("THR11", R.drawable.w_icon_04, "Rainy"));
        data.add(new Weather("FRI12", R.drawable.w_icon_02, "Cloudy"));
        data.add(new Weather("SAT13", R.drawable.w_icon_01,"Sunny"));
        data.add(new Weather("SUN14", R.drawable.w_icon_03,"Cloudy/Rainy"));

        adapter = new WeatherAdapter(this, R.layout.custom_layout , data);

        listView = (ListView) findViewById(R.id.lv_weather);
        listView.setAdapter(adapter);

    }//End onCrate
}//End
