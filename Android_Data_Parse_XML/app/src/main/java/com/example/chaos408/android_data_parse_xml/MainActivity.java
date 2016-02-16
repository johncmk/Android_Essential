package com.example.chaos408.android_data_parse_xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";

    ArrayList<Member> members = new ArrayList<Member>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser();
    }

    private void parser() {
        Log.i(TAG, "#### parser()");

        InputStream is = getResources().openRawResource(R.raw.xmlex);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader  reader = new BufferedReader(isr);

        StringBuffer sb = new StringBuffer();
        String line = null;

        XmlPullParserFactory factory = null;
        XmlPullParser xmlPullParser = null;

        try {
            factory = XmlPullParserFactory.newInstance();
            xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(reader);

            int eventType = xmlPullParser.getEventType();

            int start_doc = 0;
            int start_tag = 0;
            int end_tag = 0;
            int text = 0;
            int num = 0;

            Member member = null;
            while( eventType != XmlPullParser.END_DOCUMENT) {



                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        start_doc++;
                        Log.i(TAG, "#### Start Document");
                        break;

                    case XmlPullParser.START_TAG:
                        start_tag++;
                        Log.i(TAG, "#### Start TAG : " + xmlPullParser.getName());

                        if(xmlPullParser.getName().equals("member")) {
                            member = new Member();

                            int count = xmlPullParser.getAttributeCount();
                            for( int i = 0; i < count; i++ ) {
                                String attr_name = xmlPullParser.getAttributeName(i);
                                String attr_val = xmlPullParser.getAttributeValue(i);

                                Log.i(TAG, "#### Start TAG AttributeName( " + i + ") : " + attr_name);
                                Log.i(TAG, "#### Start TAG AttributeValue( " + i + ") : " + attr_val);

                                if(attr_name.equals("name"))
                                    member.setName(attr_val);
                                if(attr_name.equals("age"))
                                    member.setAge(Integer.parseInt(attr_val));
                            }
                        }//end member

                        if(member != null) {
                            if(xmlPullParser.getName().equals("hobby")) {
                               Log.i(TAG,"######## hobby value " + xmlPullParser.nextText());
                            }
                        }



                        break;
                    case XmlPullParser.END_TAG:
                        end_tag++;
                        Log.i(TAG, "#### End TAG : " + xmlPullParser.getName());

                        break;

                    case XmlPullParser.TEXT:
                        text++;
                        Log.i(TAG, "#### TEXT : " + xmlPullParser.getText());
                        break;
                }//End switch
                eventType = xmlPullParser.next();
                num++;
            }//Endwhile
            Log.i(TAG,"#### START_DOCUMENT iterate count : " + start_doc);
            Log.i(TAG,"#### START_TAG iterate count : " + start_tag);
            Log.i(TAG,"#### END_TAG iterate count : " + end_tag);
            Log.i(TAG,"#### TEXT iterate count : " + text);
            Log.i(TAG,"#### LOOP iterate count : " + num);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null)
                    is.close();
                if(isr != null)
                    isr.close();
                if(reader != null)
                    reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
