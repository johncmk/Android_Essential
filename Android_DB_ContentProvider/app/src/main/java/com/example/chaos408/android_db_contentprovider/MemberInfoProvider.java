package com.example.chaos408.android_db_contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by chaos408 on 2/11/2016.
 */
public class MemberInfoProvider extends ContentProvider{

    final static String TAG = "MemberInfoProvider";

    private static final String AUTHORITY ="com.example.chaos408.android_db_contentprovider.MemberInfoProvider";
    private static final String PATH ="memberInfo"; // DB name

    private static Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + PATH); //Path to DB
    private static int INFO_ALL = 1;
    private static int INFO_ONE = 2;

    private static UriMatcher matcher = null;

    static {
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITY, PATH, INFO_ALL);
        matcher.addURI(AUTHORITY, PATH + "/*", INFO_ONE);
    }

    SQLiteDatabase db = null;

    @Override
    public boolean onCreate() {

        MemberInfoHelper memberInfoHelper = new MemberInfoHelper(getContext());
        db = memberInfoHelper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        StringBuffer query = new StringBuffer();

        query.append("SELECT uname, uid, upw FROM member");

        if(matcher.match(uri) == INFO_ONE) {
            query.append(" WHERE uid = '" + uri.getPathSegments().get(1) + "'");
        }
        Log.i(TAG, "#### query : " + query.toString());
        Cursor cursor = db.rawQuery(query.toString(), null);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.i(TAG, "#### getType() ");

        if( matcher.match(uri) == INFO_ALL) {
            return "vnd.example.chaos408.android_db_contentprovider.cursor.item/member";
        }

        if( matcher.match(uri) == INFO_ONE) {
            return "vnd.example.chaos408.android_db_contentprovider.cursor.dir/member";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        long row = db.insert("member", null, values);

        if(row > 0) {
            Uri uri2 = ContentUris.withAppendedId(CONTENT_URI, row);
            getContext().getContentResolver().notifyChange(uri2, null);
            return uri2;
        }
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;

        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM member");

        if(matcher.match(uri) == INFO_ONE) {
            query.append(" WHERE uid = '" + uri.getPathSegments().get(1) + "'");
        }
        db.execSQL(query.toString());
        count = 1;
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        int count = 0;

        if (matcher.match(uri) == INFO_ALL) {
            count = db.update("member", values, selection, selectionArgs);
        } else if (matcher.match(uri) == INFO_ONE) {
            StringBuffer where = new StringBuffer("");

            where.append(" uid = '" + uri.getPathSegments().get(1) + "'");

            if(TextUtils.isEmpty(selection) == false) {
                where.append(" AND " + selection);
            }
            count = db.update("member", values, where.toString(), selectionArgs);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
