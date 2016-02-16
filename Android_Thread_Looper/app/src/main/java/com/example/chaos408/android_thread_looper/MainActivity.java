package com.example.chaos408.android_thread_looper;


import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView tvSound = null;

    private Button btnPiano = null;
    private Button btnGuitar = null;
    private Button btnDrum = null;

    private InstrumentSound instrumentSound = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSound = (TextView) findViewById(R.id.tv_sound);
        btnPiano = (Button) findViewById(R.id.bt_conversion_piano);
        btnGuitar = (Button) findViewById(R.id.bt_conversion_guitar);
        btnDrum = (Button) findViewById(R.id.bt_conversion_drum);

        btnPiano.setOnClickListener(listener);
        btnGuitar.setOnClickListener(listener);
        btnDrum.setOnClickListener(listener);

        instrumentSound = new InstrumentSound(mHandler);
        instrumentSound.setDaemon(true);
        instrumentSound.start();

    }

    Handler mHandler = new Handler() {
      public void handleMessage(Message msg) {
          String str = "";

          switch( msg.what ) {
              case InstrumentSound.SOUND_PIANO:
                  Toast.makeText(MainActivity.this, "Change to Piano Sound Complete", Toast.LENGTH_SHORT).show();
                  str = (String) msg.obj;
                  break;
              case InstrumentSound.SOUND_GUITAR:
                  Toast.makeText(MainActivity.this, "Change to Guitar Sound Complete", Toast.LENGTH_SHORT).show();
                  str = (String) msg.obj;
                  break;
              case InstrumentSound.SOUND_DRUM:
                  Toast.makeText(MainActivity.this, "Change to Drum Sound Complete", Toast.LENGTH_SHORT).show();
                  str = (String) msg.obj;
                  break;
          }
          tvSound.setText(str);
      }
    };

    View.OnClickListener listener = new View.OnClickListener() {

        Message msg;

        @Override
        public void onClick(View v) {

            switch ( v.getId() ) {
                case R.id.bt_conversion_piano:
                    msg = Message.obtain();
                    msg.what = InstrumentSound.SOUND_PIANO;
                    break;
                case R.id.bt_conversion_guitar:
                    msg = Message.obtain();
                    msg.what = InstrumentSound.SOUND_GUITAR;
                    break;
                case R.id.bt_conversion_drum:
                    msg = Message.obtain();
                    msg.what = InstrumentSound.SOUND_DRUM;
                    break;
            }
            instrumentSound.getHandler().sendMessage(msg);
        }
    };

}
