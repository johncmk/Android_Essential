package com.example.test_map2.com.android_network_image_download;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chaos408 on 2/13/2016.
 */
public class NetWorkAsyncTask extends AsyncTask<Integer, String, Integer>{

    private final static String TAG = "NetWorkAsyncTask";
    private Context mContext = null;
    private String mAddr = null;
    private ProgressDialog dialog = null;
    private String devicePath = null;
    private ImageView ivNet = null;

    public NetWorkAsyncTask(Context mContext, ImageView ivNet, String mAddr) {
        this.mContext = mContext;
        this.ivNet = ivNet;
        this.mAddr = mAddr;
    }

    @Override
    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute()");

        dialog = new ProgressDialog(mContext);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("Dialog");
        dialog.setMessage("Downloading...");
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        Log.i(TAG, "doInBackground()");

        int index = mAddr.lastIndexOf("/");
        String imgName = mAddr.substring(index+1);

        Log.i(TAG, "urlAddr : " + mAddr);
        Log.i(TAG, "index : " + index);
        Log.i(TAG, "imgName : " + imgName);

        devicePath = Environment.getDataDirectory().getAbsolutePath() + "/data/com.example.test_map2.com.android_network_image_download/files/" + imgName;
        Log.i(TAG, "devicePath : " + devicePath);

        InputStream is = null;
        FileOutputStream fos = null;

        try {
            int timeout = 10000;
            URL url = new URL(mAddr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(timeout);
            int len = conn.getContentLength();
            byte[] bs = new byte[len];

            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                is = conn.getInputStream();
                fos = mContext.openFileOutput(imgName, 0);

                while(true) {
                    int i = is.read(bs);
                    if ( i < 0)
                        break;
                    fos.write(bs, 0, i);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos != null)
                    fos.close();
                if(is != null)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    @Override
    protected void onProgressUpdate(String... values) {
        Log.i(TAG, "onProgressUpdate()");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        Log.i(TAG, "onPostExecute()");

        Bitmap bitmap = BitmapFactory.decodeFile(devicePath);
        ivNet.setImageBitmap(bitmap);

        dialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        Log.i(TAG, "onCancelled()");
        super.onCancelled();
    }
}
