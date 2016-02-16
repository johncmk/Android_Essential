package com.example.chaos408.android_event_and_listener_using_clicklistener;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.rl);

        rl.setOnClickListener(listener);

//        rl.setOnLongClickListener(longClickListener);

        rl.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "onLongClick()" , Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "onclick()", Toast.LENGTH_SHORT).show();
        }
    };

//    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
//        @Override
//        public boolean onLongClick(View v) {
//            Toast.makeText(MainActivity.this, "onLongClick()" , Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    };

}
