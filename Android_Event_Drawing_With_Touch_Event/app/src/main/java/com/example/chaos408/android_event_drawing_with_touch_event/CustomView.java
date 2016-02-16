package com.example.chaos408.android_event_drawing_with_touch_event;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by chaos408 on 2/2/2016.
 */
public class CustomView extends View {

    public final static int CURRENT_CANVAS = 0;
    public final static int NEW_CANVAS = 1;
    public final static int ERASE_CANVAS = 2;

    private Context mContext = null;
    private ArrayList<Dot> dots = new ArrayList<Dot>();
    private Paint paint = new Paint();

    public CustomView(Context context) {
        super(context);
        initPaint(CustomView.CURRENT_CANVAS,"");
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint(CustomView.CURRENT_CANVAS,"");
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(CustomView.CURRENT_CANVAS,"");
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);

        for(int i = 0; i < dots.size(); i++) {
            if(dots.get(i).isB()) {
                canvas.drawLine(dots.get(i-1).getX(),
                                dots.get(i - 1).getY(),
                                dots.get(i).getX(),
                                dots.get(i).getY(),
                                paint);
            }
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            dots.add(new Dot(event.getX(), event.getY(), false));
            return true;
        }

        if( event.getAction() == MotionEvent.ACTION_MOVE) {
            dots.add(new Dot(event.getX(), event.getY(), true));
            invalidate();
            return true;
        }
        return false;
    }

    public void initPaint (int i, String func) {


        switch(func) {
            case "Erase":
                paint.setColor(Color.WHITE);
                paint.setStrokeWidth(2);
                break;
            case "Draw":
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(2);
                break;
            default: //New Canvas
                dots.clear(); //remove all elements in the arraylist
                paint = null;
                paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setStrokeWidth(2);

                if ( i == CustomView.NEW_CANVAS ) {
                    invalidate(); //This calls onDraw method
                }
                break;
        }

        paint.setAntiAlias(true); //display pic more smooth

    }
}
