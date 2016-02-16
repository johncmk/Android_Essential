package com.example.test_map2.com.android_market_sign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by chaos408 on 2/13/2016.
 */
public class CustomView extends View {

    public final static int CURRENT_CANVAS = 0;
    public final static int NEW_CANVAS = 1;

    private Context mContxt = null;
    private ArrayList<Dot> dots = new ArrayList<>();
    private Paint paint = null;

    public CustomView(Context context) {
        super(context);
        initPaint(CustomView.CURRENT_CANVAS);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint(CustomView.CURRENT_CANVAS);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint(CustomView.CURRENT_CANVAS);
    }

    public void setmContxt(Context mContxt) {
        this.mContxt = mContxt;
    }



    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        for (int i = 0; i < dots.size(); i++) {

            if (dots.get(i).isB()) {
                canvas.drawLine(dots.get(i - 1).getX(), dots.get(i - 1).getY(),
                        dots.get(i).getX(), dots.get(i).getY(), paint);
            }

        }
    }

    public void initPaint(int i) {

        dots.clear();
        paint = null;
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);

        if(i == CustomView.NEW_CANVAS) invalidate();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            dots.add(new Dot(event.getX(), event.getY(), false));
            return true;
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            dots.add(new Dot(event.getX(), event.getY(), true));
            invalidate();
            return true;
        }

        return false;
    }
}
