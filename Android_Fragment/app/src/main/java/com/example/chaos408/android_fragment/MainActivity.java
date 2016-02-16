package com.example.chaos408.android_fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1 = null;
    Button btn2 = null;
    Button btn3 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.bt_01);
        btn2 = (Button) findViewById(R.id.bt_02);
        btn3 = (Button) findViewById(R.id.bt_03);

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);

        addFirstFragment();
    }

    private void addFirstFragment() {
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setmContext(MainActivity.this);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_right, firstFragment);
        fragmentTransaction.commit();
    }

    private void addSecondFragment() {
        SecondFragment secondFragment = new SecondFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_right, secondFragment);
        fragmentTransaction.commit();
    }

    private void addThirdFragment() {
        ThirdFragment thirdFragment = new ThirdFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_right, thirdFragment);
        fragmentTransaction.commit();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.bt_01:
                    addFirstFragment();
                    break;
                case R.id.bt_02:
                    addSecondFragment();
                    break;
                case R.id.bt_03:
                    addThirdFragment();
                    break;
            }
        }
    };

    //XML version
    public static class LeftFragment extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.frag_left, container, false);
            return view;
        }
    }


    //JAVA Version; Inner Static Class
    public static class FirstFragment extends Fragment {

        private Context mContext;

        public void setmContext(Context mContext) {
            this.mContext = mContext;
        }

        public Context getmContext() {
            return mContext;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.frag_first, container, false);

            Button btn = (Button) view.findViewById(R.id.bt_frag_first);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.bt_frag_first:
                            Toast.makeText(getmContext(), "First Fragment Btn", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            break;
                    }
                }
            });
            return view;
        }
    }//End FirstFragment

    //JAVA Version; Inner Static Class
    public static class SecondFragment extends  Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.frag_second, container, false);

            return view;
        }
    }
    //End Second Fragment

    //JAVA Version; Inner Static Class
    public static class ThirdFragment extends Fragment {

        static final String TAG = "ThirdFragment";

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            Log.i(TAG, "################onCreateView()");

            View view = inflater.inflate(R.layout.frag_third, container, false);

            return view;
        }

        @Override
        public void onStart() {
            Log.i(TAG, "################onStart()");
            super.onStart();
        }

        @Override
        public void onResume() {
            Log.i(TAG, "################onResume()");
            super.onResume();
        }

        @Override
        public void onPause() {
            Log.i(TAG, "################onPause()");
            super.onPause();
        }

        @Override
        public void onStop() {
            Log.i(TAG, "################onStop()");
            super.onStop();
        }

        @Override
        public void onDestroyView() {
            Log.i(TAG, "################onDestoryView()");
            super.onDestroyView();
        }
    }//End Third Fragment
}//End Outer Class
