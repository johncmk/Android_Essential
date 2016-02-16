package com.example.chaos408.android_file_resources;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    Button btnIn;
    TextView tvIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIn = (Button) findViewById(R.id.bt_in);
        tvIn = (TextView) findViewById(R.id.tv_in);

        btnIn.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            InputStream in = null;
            try {
                in = getResources().openRawResource(R.raw.reex);
                byte[] data = new byte[in.available()];
                while( in.read(data) != -1){

                }
                tvIn.setText(new String(data));
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
