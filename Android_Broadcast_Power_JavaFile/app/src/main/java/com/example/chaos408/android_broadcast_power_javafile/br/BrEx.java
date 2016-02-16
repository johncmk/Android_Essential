package com.example.chaos408.android_broadcast_power_javafile.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by chaos408 on 2/10/2016.
 */
public class BrEx extends BroadcastReceiver {

    final static String TAG = "BrEx";

    TextView tv = null;

    public BrEx(TextView t) {
        this.tv = t;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(TAG, "################ onReceive()");

        switch (intent.getAction()) {
            case Intent.ACTION_POWER_CONNECTED:
                Log.i(TAG, "################ power is connected [JK*]");
                tv.setText("power is Connected [JK*]");
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Log.i(TAG,"################ power is diconnected [JK*]");
                tv.setText("power is disconnceted [JK*]");
                break;

        }

    }
}
