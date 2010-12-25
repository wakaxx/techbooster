package org.jpn.techbooster.sample.xmlpullparseruri;

import java.net.URL;
import java.net.URLConnection;

import org.jpn.techbooster.sample.R;
import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;

public class XmlPullParserUrlActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        try{
            XmlPullParser xmlPullParser = Xml.newPullParser();
            
            URL url = new URL("http://techbooster.jpn.org/?feed=rss2");
            URLConnection connection = url.openConnection();
            xmlPullParser.setInput(connection.getInputStream(), "UTF-8");
            
            int eventType;
            while ((eventType = xmlPullParser.next()) != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && "title".equals(xmlPullParser.getName())) {
                    Log.d("XmlPullParserUrlActivity", xmlPullParser.nextText());
                }
            }
        } catch (Exception e){
        	Log.d("XmlPullParserUrlActivity", "Error");
        }
        
    }
}