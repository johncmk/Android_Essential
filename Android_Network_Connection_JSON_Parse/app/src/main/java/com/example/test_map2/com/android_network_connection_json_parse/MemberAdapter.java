package com.example.test_map2.com.android_network_connection_json_parse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chaos408 on 2/12/2016.
 */
public class MemberAdapter extends BaseAdapter {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Member> data = null;
    private LayoutInflater inflater = null;

    public MemberAdapter(Context mContext, int layout, ArrayList<Member> data) {
        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }

        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_age = (TextView) convertView.findViewById(R.id.tv_age);
        TextView tv_hobbys = (TextView) convertView.findViewById(R.id.tv_hobbys);
        TextView tv_no = (TextView) convertView.findViewById(R.id.tv_no);
        TextView tv_id = (TextView) convertView.findViewById(R.id.tv_id);

        tv_name.setText("Name : " + data.get(position).getName());
        tv_age.setText("Age : " + data.get(position).getAge());
        tv_hobbys.setText("Hobbys : " + data.get(position).getHobbys().toString());
        tv_no.setText("No : " + data.get(position).getNo());
        tv_id.setText("ID : " + data.get(position).getId());

        if ( (position % 2) == 1 ) {
            convertView.setBackgroundColor(0x50efefef);
        } else {
            convertView.setBackgroundColor(0x20b9b9b9);
        }

        return convertView;
    }
}
