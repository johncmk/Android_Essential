package com.example.chaos408.android_customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by chaos408 on 1/31/2016.
 */
public class CustomView extends View {

    public CustomView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);

//        canvas.drawColor(Color.GRAY);
//
//        Paint paint = new Paint();
//
//        paint.setColor(Color.RED);
//        canvas.drawPoint(110, 110, paint);
//
//        paint.setColor(Color.YELLOW);
//        canvas.drawLine(50, 50, 100, 100, paint);
//
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(150, 10, 250, 150, paint);
//
//        paint.setColor(0x5000ffff);
//        canvas.drawCircle(200, 200, 100, paint);

        canvas.drawColor(Color.LTGRAY);
        Paint paint = new Paint();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bmp);
        canvas.drawBitmap(bitmap, 6, 5, null);
    }
}
