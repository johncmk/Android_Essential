package com.example.chaos408.android_widget_checkbox;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    CheckBox cb1, cb2, cb3, cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = (CheckBox) findViewById(R.id.ch_01);
        cb2 = (CheckBox) findViewById(R.id.ch_02);
        cb3 = (CheckBox) findViewById(R.id.ch_03);
        cb4 = (CheckBox) findViewById(R.id.ch_04);

        cb1.setOnCheckedChangeListener(checkedChangeListener);
        cb2.setOnCheckedChangeListener(checkedChangeListener);
        cb3.setOnCheckedChangeListener(checkedChangeListener);
        cb4.setOnCheckedChangeListener(checkedChangeListener);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch(buttonView.getId()) {
                case R.id.ch_01:
                    Toast.makeText(MainActivity.this, buttonView.getText() + ", " + isChecked, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ch_02:
                    Toast.makeText(MainActivity.this, buttonView.getText() + ", " + isChecked, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ch_03:
                    Toast.makeText(MainActivity.this, buttonView.getText() + ", " + isChecked, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.ch_04:
                    Toast.makeText(MainActivity.this, buttonView.getText() + ", " + isChecked, Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    };

}
