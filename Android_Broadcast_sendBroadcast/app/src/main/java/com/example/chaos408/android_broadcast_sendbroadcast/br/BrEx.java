package com.example.chaos408.android_broadcast_sendbroadcast.br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.chaos408.android_broadcast_sendbroadcast.WorkActivity;

/**
 * Created by chaos408 on 2/10/2016.
 */
public class BrEx extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent i) {

        Intent intent = new Intent(context, WorkActivity.class);
        intent.putExtra("strName", "strValue");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
