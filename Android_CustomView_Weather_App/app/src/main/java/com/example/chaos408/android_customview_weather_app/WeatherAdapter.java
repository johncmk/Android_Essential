package com.example.chaos408.android_customview_weather_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by chaos408 on 2/1/2016.
 */
public class WeatherAdapter extends BaseAdapter {

    private Context mContext =  null;
    private int layout = 0;
    private ArrayList<Weather> data = null;
    private LayoutInflater inflater = null;// This is smart way of doing it

    public WeatherAdapter(Context context, int layout, ArrayList<Weather> data) {
        this.mContext = context;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);// This is smart way of doing it
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getDay();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }

        TextView tv_day = (TextView) convertView.findViewById(R.id.tv_day);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_weather);
        TextView tv_comment = (TextView) convertView.findViewById(R.id.tv_comment);
        Button bt_select = (Button) convertView.findViewById(R.id.bt_select);

        tv_day.setText(data.get(position).getDay() + " | ");
        iv_icon.setImageResource(data.get(position).getIcon());
        tv_comment.setText(data.get(position).getComment());

        if( (position % 2 ) == 1 ) {
            convertView.setBackgroundColor(0x5000ff00);
        } else {
            convertView.setBackgroundColor(0x2000ff00);
        }

        return convertView;
    }
}
