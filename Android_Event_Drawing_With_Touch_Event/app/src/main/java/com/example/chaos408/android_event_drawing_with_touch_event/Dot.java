package com.example.chaos408.android_event_drawing_with_touch_event;

/**
 * Created by chaos408 on 2/2/2016.
 */
public class Dot {

    private float x, y;
    private boolean b;

    public Dot(float x, float y, boolean b) {
        this.x = x;
        this.y = y;
        this.b = b;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}//End Class
