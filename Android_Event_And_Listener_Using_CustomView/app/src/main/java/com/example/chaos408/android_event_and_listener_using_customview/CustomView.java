package com.example.chaos408.android_event_and_listener_using_customview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by chaos408 on 2/2/2016.
 */
public class CustomView extends View {

    private Context mContext;

    public CustomView(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            Toast.makeText(this.mContext , "MotionEvent.Action_down" , Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}
