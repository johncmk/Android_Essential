package com.example.test_map2.com.android_market_sign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CustomView customView = null;
    private Button newCanvansBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = (CustomView) findViewById(R.id.customView);
        customView.setmContxt(MainActivity.this);

        newCanvansBtn = (Button) findViewById(R.id.bt_new_canvas);
        newCanvansBtn.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch ( v.getId() ){
                case R.id.bt_new_canvas:
                    customView.initPaint(CustomView.NEW_CANVAS);
                    break;
                default:
                    break;
            }//End
        }
    };
}
