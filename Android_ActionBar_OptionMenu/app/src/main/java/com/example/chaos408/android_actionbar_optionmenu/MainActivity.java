package com.example.chaos408.android_actionbar_optionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv01 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01 = (TextView) findViewById(R.id.tv_01);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.action_menu01:
                Toast.makeText(MainActivity.this, "action_menu01" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu02:
                Toast.makeText(MainActivity.this, "action_menu02" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_menu03:
                Toast.makeText(MainActivity.this, "action_menu03" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_01:
                Toast.makeText(MainActivity.this, "menu_01" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_02:
                Toast.makeText(MainActivity.this, "menu_02" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_03:
                Toast.makeText(MainActivity.this, "menu_03" , Toast.LENGTH_SHORT).show();
                break;
        }

        tv01.setText(item.getTitle().toString());

        return false;
    }//End onOptionItemSelected

}//End Class
