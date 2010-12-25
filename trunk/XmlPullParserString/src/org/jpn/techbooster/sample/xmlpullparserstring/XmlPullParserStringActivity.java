package org.jpn.techbooster.sample.xmlpullparserstring;

import java.io.StringReader;

import org.jpn.techbooster.sample.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;

public class XmlPullParserStringActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        XmlPullParser xmlPullParser = Xml.newPullParser();
        
        try {
			xmlPullParser.setInput( new StringReader ( "<TAG1>hoge<TAG2>foo</TAG2></TAG1>" ) );
		} catch (XmlPullParserException e) {
			 Log.d("XmlPullParserStringActivity", "Error");
		}
		
		try {
	        int eventType;
			eventType = xmlPullParser.getEventType();
	        while (eventType != XmlPullParser.END_DOCUMENT) {
	            if(eventType == XmlPullParser.START_DOCUMENT) {
	                Log.d("XmlPullParserStringActivity", "Start document");
	            } else if(eventType == XmlPullParser.END_DOCUMENT) {
	            	Log.d("XmlPullParserStringActivity", "End document");
	            } else if(eventType == XmlPullParser.START_TAG) {
	            	Log.d("XmlPullParserStringActivity", "Start tag "+xmlPullParser.getName());
	            } else if(eventType == XmlPullParser.END_TAG) {
	            	Log.d("XmlPullParserStringActivity", "End tag "+xmlPullParser.getName());
	            } else if(eventType == XmlPullParser.TEXT) {
	            	Log.d("XmlPullParserStringActivity", "Text "+xmlPullParser.getText());
	            }
	            eventType = xmlPullParser.next();
	        }
		} catch (Exception e) {
			 Log.d("XmlPullParserStringActivity", "Error");
		}
    }
}