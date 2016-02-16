package com.example.chaos408.android_customview_weather_app;

/**
 * Created by chaos408 on 2/1/2016.
 */
public class Weather {

    private String day;
    private int icon;
    private String comment;

    public Weather() {
    }

    public Weather(String day, int icon, String comment) {
        this.day = day;
        this.icon = icon;
        this.comment = comment;
    }

    public String getDay() {
        return day;
    }

    public int getIcon() {
        return icon;
    }

    public String getComment() {
        return comment;
    }
}//End
