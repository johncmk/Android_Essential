package com.example.chaos408.android_file_drectory;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    Button btnOut, btnIn, btnDelete;
    EditText etOut;
    TextView tvIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOut = (Button) findViewById(R.id.bt_out);
        btnIn = (Button) findViewById(R.id.bt_in);
        btnDelete = (Button) findViewById(R.id.bt_delete);
        etOut = (EditText) findViewById(R.id.et_out);
        tvIn = (TextView) findViewById(R.id.tv_in);

        btnOut.setOnClickListener(listener);
        btnIn.setOnClickListener(listener);
        btnDelete.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch ( v.getId() ) {

                case R.id.bt_out:
                    Log.i(TAG, "################ out");
                    FileOutputStream fos = null;
                    try {
                        fos = openFileOutput("et.txt", Context.MODE_PRIVATE);
                        String out = etOut.getText().toString();
                        fos.write(out.getBytes());
                        Toast.makeText(MainActivity.this, "Write data complete; save as et.txt", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (fos != null) {
                                fos.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case R.id.bt_in:
                    Log.i(TAG, "################ in");
                    FileInputStream fis = null;
                    try {
                        fis = openFileInput("ex.txt");
                        byte[] data = new byte[fis.available()];

                        while( fis.read(data) != -1) {

                        }
                        tvIn.setText(new String(data));
                        Toast.makeText(MainActivity.this, "read end", Toast.LENGTH_SHORT).show();
                    } catch(Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (fis != null) {
                                fis.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case R.id.bt_delete:
                    Log.i(TAG, "################ delete");
                    boolean b = deleteFile("ex.txt");
                    if(b) {
                        Toast.makeText(MainActivity.this, "Delete OK!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Delete NG!", Toast.LENGTH_SHORT).show();
                    }
                    break;

            }//End Switch
        }
    };
}
