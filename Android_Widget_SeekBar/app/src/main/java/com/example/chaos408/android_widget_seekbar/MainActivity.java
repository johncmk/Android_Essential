package com.example.chaos408.android_widget_seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar sb = null;
    private Button progressBtn = null;
    private Button resetBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb = (SeekBar) findViewById(R.id.sb_01);
        progressBtn = (Button) findViewById(R.id.bt_01);
        resetBtn = (Button) findViewById(R.id.bt_02);

        sb.setOnClickListener(onClickListener);
        progressBtn.setOnClickListener(onClickListener);
        resetBtn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.bt_01:
                    Toast.makeText(MainActivity.this, "Progress", Toast.LENGTH_SHORT).show();
                    sb.incrementProgressBy(10);
                    sb.incrementSecondaryProgressBy(10);
                    break;

                case R.id.bt_02:
                    Toast.makeText(MainActivity.this, "Reset" , Toast.LENGTH_SHORT).show();
                    sb.setProgress(0);
                    sb.setSecondaryProgress(100);
                    break;
            }
        }
    };
}
