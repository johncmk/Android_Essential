package com.example.chaos408.android_thread_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn01, btn02;
    NewAsyncTask newAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_01);
        btn01 = (Button) findViewById(R.id.bt_01);
        btn01.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.bt_01:
                    newAsyncTask = new NewAsyncTask(MainActivity.this, tv);
                    //doInbackground
                    //params[0] == 100
                    //params[1] == 50
                    newAsyncTask.execute(100,50);
                    break;
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
