package com.example.test_map2.com.android_network_connection;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chaos408 on 2/12/2016.
 */
public class NetWorkAsyncTask extends AsyncTask<Integer, String, Integer> {

    private final static String TAG = "NetWorkAsyncTask";
    private Context mContext = null;
    private String mAddr = null;
    private ProgressDialog dialog = null;

    public NetWorkAsyncTask(Context c , String mAddr) {
        this.mContext = c;
        this.mAddr = mAddr;
    }

    @Override
    protected void onPreExecute() {
        Log.i(TAG, "#### onPreExecute()");

        dialog = new ProgressDialog(mContext);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Dialog");
        dialog.setMessage("downloading...");
        dialog.setCancelable(false);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @Override
    protected Integer doInBackground(Integer... params) {
        Log.i(TAG, "#### doInBackground()");

        StringBuffer sb = new StringBuffer();
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {

            URL url = new URL(mAddr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(10000);

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                is = connection.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                String strLine = null;
                do{
                    strLine = br.readLine();
                    sb.append(strLine + "\n");
                } while(strLine != null);


//                while(true) {
//                    String strLine = br.readLine();
//                    if (strLine == null) {
//                        break;
//                    }
//                    sb.append(strLine + "\n");
//                }
                Log.i(TAG, "#### sb : " + sb.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (isr != null)
                    isr.close();
                if (br != null)
                    br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
