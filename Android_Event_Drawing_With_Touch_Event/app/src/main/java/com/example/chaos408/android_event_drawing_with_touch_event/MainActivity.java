package com.example.chaos408.android_event_drawing_with_touch_event;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CustomView customView = null;

    private Button btnNewCanvas = null;
    private Button btnEraseCanvas = null;
    private Button btnDrawCanvas = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = (CustomView) findViewById(R.id.customView);
        customView.setmContext(MainActivity.this);

        btnNewCanvas = (Button) findViewById(R.id.bt_new_canvas);
        btnNewCanvas.setOnClickListener(onClickListener);

        btnEraseCanvas = (Button) findViewById(R.id.bt_erase_canvas);
        btnEraseCanvas.setOnClickListener(onClickListener);

        btnDrawCanvas = (Button) findViewById(R.id.bt_draw_canvas);
        btnDrawCanvas.setOnClickListener(onClickListener);


    }//End onCreate

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch(v.getId()) {
                case R.id.bt_new_canvas:
                    customView.initPaint(CustomView.NEW_CANVAS, "");
                    break;
                case R.id.bt_draw_canvas:
                    customView.initPaint(CustomView.CURRENT_CANVAS, "Draw");
                    break;
                case R.id.bt_erase_canvas:
                    customView.initPaint(CustomView.ERASE_CANVAS, "Erase");
                    break;
                default:
                    break;
            }
        }
    };

}//End Class
