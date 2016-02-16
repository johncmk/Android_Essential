package com.example.chaos408.android_adapterview_horizontalview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    private int[] data ={R.drawable.s01, R.drawable.s02,
            R.drawable.s03, R.drawable.s04, R.drawable.s05};

    private CustomAdapter adapter = null;
    private GridView gv;

    private LinearLayout ll;
    private ImageView[] ivs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        adapter = new CustomAdapter(this, data);
        gv = (GridView) findViewById(R.id.gv_01);
        gv.setAdapter(adapter);
*/
        ll = (LinearLayout) findViewById(R.id.ll_01);
        ivs = new ImageView[5];

        for(int i = 0; i < data.length ;i++) {
            ivs[i] = new ImageView(this);
            ivs[i].setImageResource(data[i]);
            ll.addView(ivs[i]);
        }

    }
}
