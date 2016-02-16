package com.example.test_map2.com.android_market_sign;

/**
 * Created by chaos408 on 2/13/2016.
 */
public class Dot {

    private float x,y;
    private boolean b;

    public Dot() {
    }

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
}
