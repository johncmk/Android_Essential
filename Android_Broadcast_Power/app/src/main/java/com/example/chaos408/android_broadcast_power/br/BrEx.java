package com.example.chaos408.android_broadcast_power.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.chaos408.android_broadcast_power.WorkActivity;

/**
 * Created by chaos408 on 2/10/2016.
 */
public class BrEx extends BroadcastReceiver{

    final static String TAG = "BrEx";
    final static String STRING_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
    final static String STRING_POWER_DISCONNECTED = "android.intent.action.ACTION_POWER_DISCONNECTED";


    @Override
    public void onReceive(Context context, Intent i) {
        Log.i(TAG, "################ onReceive()");

        Intent intent = new Intent(context, WorkActivity.class);

        switch (i.getAction()) {
            case STRING_POWER_CONNECTED:
                intent.putExtra("powerStatus", "power is connected [JK]");
                break;
            case STRING_POWER_DISCONNECTED:
                intent.putExtra("powerStatus", "power is disconnected [JK]");
                break;
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
