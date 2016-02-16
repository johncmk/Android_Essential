package com.example.chaos408.android_popup_message;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_alert = null;
    Button btn_custom = null;
    Button btn_progress = null;
    
    TextView tv_menu = null;
    ProgressDialog pd = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn_alert = (Button) findViewById(R.id.bt_01);
        btn_custom = (Button) findViewById(R.id.bt_02);
        btn_progress = (Button) findViewById(R.id.bt_03);
        tv_menu = (TextView) findViewById(R.id.tv_01);

        btn_alert.setOnClickListener(onClickListener);
        btn_custom.setOnClickListener(onClickListener);
        btn_progress.setOnClickListener(onClickListener);
    }
    
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            
            switch(v.getId()) {
                case R.id.bt_01:

                    new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Lunch Menu")
                        .setMessage("How about pizza?")
                        .setIcon(R.drawable.g08)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                                tv_menu.setText("Pizza is delivered. Thank you!");
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "NG", Toast.LENGTH_SHORT).show();
                                tv_menu.setText("Can you choose your order again?");
                            }
                        }).show();
                   break;

                case R.id.bt_02:

                    LinearLayout ll = (LinearLayout) View.inflate(MainActivity.this, R.layout.custom_dialog, null);
                    final EditText et = (EditText) ll.findViewById(R.id.ev_01);

                    new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Dinner Menu")
                        .setView(ll)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "OK" , Toast.LENGTH_SHORT).show();
                                String input = et.getText().toString();
                                tv_menu.setText(input);
                            }
                        })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "CANCEL" , Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.bt_03:
                    pd = new ProgressDialog(MainActivity.this);
                    pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    pd.setIcon(R.drawable.g08);
                    pd.setTitle("Download");
                    pd.setMessage("Progress...");
                    pd.show();;
//                    pd.hide();
                    break;
            }
        }
    };
    
}//End Class
