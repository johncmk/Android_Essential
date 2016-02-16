package com.example.test_map2.com.android_network_connection_json_parse;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by chaos408 on 2/12/2016.
 */
public class NetWorkAsyncTask extends AsyncTask<Integer, String, Object> {

    private final static String TAG = "NetWorkAsyncTask";
    private Context mContext = null;
    private String mAddr = null;
    private ProgressDialog dialog = null;
    private ArrayList<Member> members = null;

    public NetWorkAsyncTask(Context mContext, String mAddr) {
        this.mContext = mContext;
        this.mAddr = mAddr;
        this.members = new ArrayList<Member>();
    }

    @Override
    protected void onPreExecute() {
        Log.i(TAG, "#### onPreExecute()");

        dialog = new ProgressDialog(mContext);
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Dialog");
        dialog.setMessage("Downloading...");
        dialog.setCancelable(false);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    protected Object doInBackground(Integer... params) {
        Log.i(TAG, "#### doInBackground()");

        StringBuffer sb = new StringBuffer();
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            int timeout = 10000;
            URL url = new URL(mAddr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(timeout);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
//            conn.connect();
            int status = conn.getResponseCode(); //200

            if(status == HttpURLConnection.HTTP_OK) {

                is = conn.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                while (true) {

                    String strLine = br.readLine();
                    if (strLine == null) break;

                    sb.append(strLine + "\n");
                }

                Log.i(TAG, "######## sb: " + sb.toString());
                parser(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if ( is != null)
                    is.close();
                if ( isr != null)
                    isr.close();
                if ( br != null)
                    br.close();
            } catch ( Exception e) {
                e.printStackTrace();
            }
        }
        return members;
    }

    private void parser(String s) {
        Log.i(TAG, "#### parser()");
        Log.i(TAG, "######## s : " + s);

        try {

            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));

            members.clear();

            for( int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String name = jsonObject1.getString("name");
                Log.i(TAG, "############ name : " + name);

                int age = jsonObject1.getInt("age");
                Log.i(TAG, "############ age : " + age);

                ArrayList<String> hobbys = new ArrayList<>();
                JSONArray jsonArray2 = jsonObject1.getJSONArray("hobbys");
                for ( int j = 0; j < jsonArray2.length(); j++) {
                    String hobby = jsonArray2.getString(j);
                    Log.i(TAG, "############ hobby[" + j + "] : " + hobby);
                    hobbys.add(hobby);
                }

                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                Log.i(TAG, "############ no : " + no);

                String id = jsonObject2.getString("id");
                Log.i(TAG, "############ id : " + id);

                int pw = jsonObject2.getInt("pw");
                Log.i(TAG, "############ pw : " + pw);

                Member member = new Member(name, age, hobbys, no, id, pw);
                members.add(member);

            }

        } catch ( Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onProgressUpdate(String... values) {
        Log.i(TAG, "#### onProgressUpdate()");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        Log.i(TAG, "#### onPostExecute()");
        super.onPostExecute(o);
    }

    @Override
    protected void onCancelled() {
        Log.i(TAG, "#### onCancelled()");
        super.onCancelled();
    }


}
