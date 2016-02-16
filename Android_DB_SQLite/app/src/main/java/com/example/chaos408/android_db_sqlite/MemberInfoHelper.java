package com.example.chaos408.android_db_sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by chaos408 on 2/11/2016.
 */
public class MemberInfoHelper extends SQLiteOpenHelper{

    final static String TAG = "MemberInfoHelper";

    public MemberInfoHelper(Context c) {
        super(c, "MemberInfo.db", null, 1);
    }

    public MemberInfoHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MemberInfoHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "#### onCreate()");
        String query = "CREATE TABLE member (_id INTEGER PRIMARY KEY AUTOINCREMENT, uname TEXT, uid TEXT, upw INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "#### onUpgrade()");
        String query = "DROP TABLE IF EXISTS member";
        db.execSQL(query);
        onCreate(db);
    }
}
