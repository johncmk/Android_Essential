package com.example.chaos408.android_intent_implicit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_dial = (Button) findViewById(R.id.bt_dial);
        Button bt_call = (Button) findViewById(R.id.bt_call);
        Button bt_contact = (Button) findViewById(R.id.bt_contact);
        Button bt_web_browser = (Button) findViewById(R.id.bt_web_browser);
        Button bt_sms = (Button) findViewById(R.id.bt_sms);

        bt_dial.setOnClickListener(listener);
        bt_call.setOnClickListener(listener);
        bt_contact.setOnClickListener(listener);
        bt_web_browser.setOnClickListener(listener);
        bt_sms.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Uri uri = null;
            Intent intent = null;

            switch (v.getId()) {
                case R.id.bt_dial:
                    Toast.makeText(MainActivity.this, "Dial", Toast.LENGTH_SHORT).show();
                    uri = Uri.parse("tel:0101235678");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.bt_call:
                    Toast.makeText(MainActivity.this, "Call", Toast.LENGTH_SHORT).show();
                    uri = Uri.parse("tel:0101235678");
                    intent = new Intent(Intent.ACTION_CALL, uri);
                    break;
                case R.id.bt_contact:
                    Toast.makeText(MainActivity.this, "Contact" , Toast.LENGTH_SHORT).show();
                    uri = Uri.parse("content://contacts/people/");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.bt_web_browser:
                    Toast.makeText(MainActivity.this , "Web Browser", Toast.LENGTH_SHORT).show();
                    uri = Uri.parse("http://google.com");
                    intent = new Intent(Intent.ACTION_WEB_SEARCH, uri);
                    break;
                case R.id.bt_sms:
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.putExtra("sms_body","This is txt msg.");
                    intent.setType("vnd.android-dir/mms-sms");
                    break;
            }
            if(intent != null) {
                startActivity(intent);
            }
        }
    };

}
