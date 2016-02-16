package com.example.chaos408.android_adapterview_gridview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends Activity {

    private int[] data = {R.drawable.g01, R.drawable.g02, R.drawable.g03, R.drawable.g04, R.drawable.g05,
            R.drawable.g06, R.drawable.g07, R.drawable.g08, R.drawable.g09, R.drawable.g10,
            R.drawable.g01, R.drawable.g02, R.drawable.g03, R.drawable.g04, R.drawable.g05,
            R.drawable.g06, R.drawable.g07, R.drawable.g08, R.drawable.g09, R.drawable.g10,
            R.drawable.g01, R.drawable.g02, R.drawable.g03, R.drawable.g04, R.drawable.g05,
            R.drawable.g06, R.drawable.g07, R.drawable.g08, R.drawable.g09, R.drawable.g10
    };

    private CustomerAdapter adapter = null;
    private GridView gv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomerAdapter(this, data);

        gv = (GridView) findViewById(R.id.gv_01);
        gv.setAdapter(adapter);
    }
}
