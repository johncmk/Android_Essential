package com.example.chaos408.android_data_parse_token;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser();
    }

    private void parser() {
        Log.i(TAG, "################ parser()");

        InputStream is = getResources().openRawResource(R.raw.tokenex);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        StringBuffer sb = new StringBuffer();
        String line = null;

        try {

            while( (line = reader.readLine()) != null) {
                sb.append(line);
            }
            Log.i(TAG,"################ sb : " + sb.toString());

            String str = sb.toString();
            StringTokenizer tokenizer = new StringTokenizer(str, "|");
            Log.i(TAG, "################ Token count : " + tokenizer.countTokens());

            while( tokenizer.hasMoreElements()) {
                String tokenStr = tokenizer.nextToken();
                Log.i(TAG, "################ Token string(|) : " + tokenStr);

                StringTokenizer tokenizer2 = new StringTokenizer(tokenStr, ",");
                Log.i(TAG, "################ Token : " + tokenizer2.countTokens());
                while( tokenizer2.hasMoreElements()) {
                    String tokenStr2 = tokenizer2.nextToken();
                    Log.i(TAG, "################ Token string(,) : " + tokenStr2);
                }
                Log.i(TAG, "==================================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (isr != null)
                    isr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
