package com.example.chaos408.android_data_parse_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser2();
    }

    private void parser() {
        Log.i(TAG, "parser()");

        InputStream is = getResources().openRawResource(R.raw.jsonex);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            Log.i(TAG, "sb : " + sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            String name = jsonObject.getString("name");
            Log.i(TAG, "name : " + name);
            int age = jsonObject.getInt("age");
            Log.i(TAG, "age : " + age);
            JSONArray jsonArray = jsonObject.getJSONArray("hobbys");
            for (int i = 0; i < jsonArray.length(); i++) {
                String hobby = jsonArray.getString(i);
                Log.i(TAG, "hobbys[" + i + "] : " + hobby);
            }
            JSONObject jsonObject2 = jsonObject.getJSONObject("info");
            int no = jsonObject2.getInt("no");
            Log.i(TAG, "no : " + no);
            String id = jsonObject2.getString("id");
            Log.i(TAG, "id : " + id);
            int pw = jsonObject2.getInt("pw");
            Log.i(TAG, "pw : " + pw);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    private void parser2() {
        Log.i(TAG, "#### parser()2");

        InputStream is = getResources().openRawResource(R.raw.jsonex2);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        StringBuffer sb = new StringBuffer();
        String line = null;

        try {

            while( (line = reader.readLine()) != null ) {
                sb.append(line);
            }

            Log.i(TAG, "#### sb : " + sb.toString());

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));

            for ( int i = 0; i < jsonArray.length() ; i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

                String name = jsonObject1.getString("name");
                Log.i(TAG, "#### name : " + name);

                int age = jsonObject1.getInt("age");
                Log.i(TAG, "#### age : " + age);
                JSONArray jsonArray2 = jsonObject1.getJSONArray("hobbys");

                for ( int j = 0; j < jsonArray2.length();j++) {
                    String hobby = jsonArray2.getString(j);
                    Log.i(TAG, "#### hobbys["+i+"] : " + hobby);
                }

                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                Log.i(TAG, "#### no : " + no);

                String id = jsonObject2.getString("id");
                Log.i(TAG, "#### id : " + id);

                int pw = jsonObject2.getInt("pw");
                Log.i(TAG, "#### pw : " + pw);


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if ( isr != null)
                    isr.close();
                if ( reader != null)
                    reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
