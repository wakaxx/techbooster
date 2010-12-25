package org.jpn.techbooster.sample.defaulthttpclient;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jpn.techbooster.sample.R;
import org.xmlpull.v1.XmlPullParser;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;

public class DefaultHttpClientSampleActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        HttpClient httpClient = new DefaultHttpClient();
        
        StringBuilder uri = new StringBuilder("http://techbooster.jpn.org/?feed=rss2");
        HttpGet request = new HttpGet(uri.toString()); 
        HttpResponse httpResponse = null;
        
        try {
        	httpResponse = httpClient.execute(request);
        } catch (Exception e) {
        	Log.d("DefaultHttpClientSampleActivity", "Error Execute");
        }
        
        int status = httpResponse.getStatusLine().getStatusCode(); 
        
        if (HttpStatus.SC_OK == status) { 
        	try {
        		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
        		httpResponse.getEntity().writeTo(outputStream);
        		parse(outputStream.toString());
        	} catch (Exception e) {
            	Log.d("DefaultHttpClientSampleActivity", "Error");
			}
        } else {
        	Log.d("DefaultHttpClientSampleActivity", "Status" + status);        	
        }
    }
    
    void parse(String str) {
        try{
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setInput(new StringReader(str));
            
            int eventType;
            while ((eventType = xmlPullParser.next()) != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && "title".equals(xmlPullParser.getName())) {
                    Log.d("DefaultHttpClientSampleActivity", xmlPullParser.nextText());
                }
            }
        } catch (Exception e){
        	Log.d("DefaultHttpClientSampleActivity", "Error:parse");
        }
    }
}