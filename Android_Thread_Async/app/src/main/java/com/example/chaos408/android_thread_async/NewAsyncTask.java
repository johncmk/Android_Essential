package com.example.chaos408.android_thread_async;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by chaos408 on 2/10/2016.
 */
public class NewAsyncTask extends AsyncTask<Integer, String, Integer> {

    final static String TAG = "NewAsyncTask";

    Context mContext = null;
    TextView mTv = null;
    ProgressDialog dialog = null;
    boolean cancelFlag = false;

    public NewAsyncTask(Context c, TextView t) {
        this.mContext = c;
        this.mTv = t;
    }


    @Override
    protected void onPreExecute() {
        Log.i(TAG, "################ onPreExecute()");

        dialog = new ProgressDialog(mContext);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("Dialog");
        dialog.setMessage("work start");
        dialog.setCancelable(false);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                cancelFlag = true;
                cancel(true);
            }
        });
        dialog.setProgress(0);
        dialog.show();
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        Log.i(TAG, "################ doInBackground()");
        Log.i(TAG, "################ param[0] : " + params[0]);
        Log.i(TAG, "################ param[1] : " + params[1]);

        for (int i = 0; i < params[0]; i++) {
            publishProgress(String.valueOf(i));
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return params[0];
    }

    @Override
    protected void onProgressUpdate(String... values) {
        Log.i(TAG, "################ onProgressUpdate()");

        int i = Integer.parseInt(values[0]);
        dialog.setProgress(i);
        mTv.setText(String.valueOf(i));
    }

        @Override
    protected void onPostExecute(Integer integer) {
        Log.i(TAG, "################ onPostExecute()");
        Log.i(TAG, "################ result/integer : " + integer);

        mTv.setText(String.valueOf(integer));
        dialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        Log.i(TAG, "################ onCancelled()");

        mTv.setText("Cancelled");
        dialog.dismiss();
    }
}
