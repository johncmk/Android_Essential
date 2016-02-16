package com.example.chaos408.android_thread_class_detach;

import android.os.Handler;
import android.os.Message;

/**
 * Created by chaos408 on 2/10/2016.
 */
public class NewThread extends Thread {

    final static int NEWTHREAD_WHAT = 0;

    private Handler mHandler;
    private int secondNum;

    public NewThread (Handler h, int sn) {
        this.mHandler = h;
        this.secondNum = sn;
    }

    @Override
    public void run() {

        while (true) {
            secondNum++;
            Message msg = Message.obtain();
            msg.what = NEWTHREAD_WHAT;
            msg.arg1 = secondNum;
            mHandler.sendMessage(msg);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
