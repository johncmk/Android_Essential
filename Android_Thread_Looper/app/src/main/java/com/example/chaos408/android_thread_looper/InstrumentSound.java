package com.example.chaos408.android_thread_looper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by chaos408 on 2/10/2016.
 */
public class InstrumentSound extends Thread {

    final static int SOUND_PIANO = 0;
    final static int SOUND_GUITAR = 1;
    final static int SOUND_DRUM = 2;

    private Handler mHandler = null;
    private Handler handler = null;

    public InstrumentSound(Handler h) {
        this.mHandler = h;
    }

    public Handler getHandler() {
        return handler;
    }

    @Override
    public void run() {

        Looper.prepare();

        handler = new Handler() {
          public void handleMessage(Message msg) {
              Message msgForMain = Message.obtain();

              switch (msg.what) {
                  case SOUND_PIANO:
                      try {
                          Thread.sleep(3000);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                      msgForMain.what = SOUND_PIANO;
                      msgForMain.obj = "Piano Sound";
                      break;
                  case SOUND_GUITAR:
                      try {
                          Thread.sleep(3000);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                      msgForMain.what = SOUND_GUITAR;
                      msgForMain.obj = "Guitar Sound";
                      break;
                  case SOUND_DRUM:
                      try {
                          Thread.sleep(3000);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                      msgForMain.what = SOUND_DRUM;
                      msgForMain.obj = "Drum Sound";
                      break;
              }
              mHandler.sendMessage(msgForMain);
          }
        };

        Looper.loop();
    }
}
