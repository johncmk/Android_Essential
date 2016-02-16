package com.example.chaos408.android_file_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etCountry, etLanguage;
    Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCountry = (EditText) findViewById(R.id.et_country);
        etLanguage = (EditText) findViewById(R.id.et_language);

        btnSet = (Button) findViewById(R.id.bt_set);

        btnSet.setOnClickListener(onClickListener);
        init();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        //input value to preference xml
        @Override
        public void onClick(View v) {
            SharedPreferences sp = getSharedPreferences("preference", 0);
            SharedPreferences.Editor editor = sp.edit();

            String country = etCountry.getText().toString();
            String language = etLanguage.getText().toString();

            editor.putString("country", country);
            editor.putString("language", language);
            editor.commit(); // finally commit
        }
    };

    /**
     * Initialization/default setting for textview by read data from file
     */
    private void init() {
        SharedPreferences sp = getSharedPreferences("preference",0);
        String country = sp.getString("country","US");
        String language = sp.getString("language", "English");

        etCountry.setText(country);
        etLanguage.setText(language);

    }

    /**
     * In case user forgot to press the button and hide this app to background
     * But, I personally doubt this is a good idea, which takes over user's ownership saves
     * data regardless press the button.
     */
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("preference",0);
        SharedPreferences.Editor editor = sp.edit();

        String country = etCountry.getText().toString();
        String language = etLanguage.getText().toString();

        editor.putString("country", country);
        editor.putString("language", language);
        editor.commit();
    }
}
