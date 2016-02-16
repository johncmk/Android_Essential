package com.example.chaos408.android_db_contentprovider_call_contetntprovider;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "MainActivity";

    private static final String AUTHORITY = "com.example.chaos408.android_db_contentprovider.MemberInfoProvider";
    private static final String PATH = "memberInfo";
    private static final String UID = "john_orm";

    private static Uri CONTENT_URI_MEMEBERS = Uri.parse("content://" + AUTHORITY + "/" + PATH);
    private static Uri CONTENT_URI_MEMEBER = Uri.parse("content://" + AUTHORITY + "/" + PATH + "/" + UID);

    ContentResolver cr = null;
    Button btnInsert, btnDelete, btnUpdate, btnSelectAll, btnSelectOne;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cr =
    }
}
