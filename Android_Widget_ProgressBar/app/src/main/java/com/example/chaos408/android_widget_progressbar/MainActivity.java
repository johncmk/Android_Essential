package com.example.chaos408.android_widget_progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb01;
    private ProgressBar pb02;

    private Button progressBtn;
    private Button resetBtn;
    private Button showBtn;
    private Button hideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb01 = (ProgressBar) findViewById(R.id.pb_01);
        pb02 = (ProgressBar) findViewById(R.id.pb_02);
        progressBtn = (Button) findViewById(R.id.bt_01);
        resetBtn = (Button) findViewById(R.id.bt_02);
        showBtn = (Button) findViewById(R.id.bt_03);
        hideBtn = (Button) findViewById(R.id.bt_04);

        progressBtn.setOnClickListener(clickListener);
        resetBtn.setOnClickListener(clickListener);
        showBtn.setOnClickListener(clickListener);
        hideBtn.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_01:
                    Toast.makeText(MainActivity.this , "Progress" , Toast.LENGTH_SHORT).show();
                    pb01.incrementProgressBy(10);
                    pb01.incrementSecondaryProgressBy(10);
                    break;

                case R.id.bt_02:
                    Toast.makeText(MainActivity.this , "Reset" , Toast.LENGTH_SHORT).show();
                    pb01.setProgress(0);
                    pb01.setSecondaryProgress(100);
                    break;

                case R.id.bt_03:
                    Toast.makeText(MainActivity.this , "Show" , Toast.LENGTH_SHORT).show();
                    pb02.setVisibility(ProgressBar.VISIBLE);
                    break;

                case R.id.bt_04:
                    Toast.makeText(MainActivity.this , "Hide" , Toast.LENGTH_SHORT).show();
                    pb02.setVisibility(ProgressBar.INVISIBLE);
                    break;
            }
        }
    };

}
