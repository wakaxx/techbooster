package org.jpn.techbooster.sample.json;

import java.io.ByteArrayOutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jpn.techbooster.sample.R;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class JSONSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        HttpClient httpClient = new DefaultHttpClient();
        
        StringBuilder uri = new StringBuilder("http://api.atnd.org/events/?keyword=android&format=json");
        HttpGet request = new HttpGet(uri.toString()); 
        HttpResponse httpResponse = null;
        
        try {
        	httpResponse = httpClient.execute(request);
        } catch (Exception e) {
        	Log.d("JSONSampleActivity", "Error Execute");
        	return;
        }
        
        int status = httpResponse.getStatusLine().getStatusCode(); 
        
        if (HttpStatus.SC_OK == status) { 
        	try {
        		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); 
        		httpResponse.getEntity().writeTo(outputStream);
                String data;
                data = outputStream.toString();
                
                JSONObject rootObject = new JSONObject(data);
                JSONArray eventArray = rootObject.getJSONArray("events");
                for (int i = 0; i < eventArray.length(); i++) {
                    JSONObject jsonObject = eventArray.getJSONObject(i);
                    Log.d("JSONSampleActivity", jsonObject.getString("title"));
                }
        	} catch (Exception e) {
            	Log.d("JSONSampleActivity", "Error");
			}
        } else {
        	Log.d("JSONSampleActivity", "Status" + status);
        	return;
        }
        
    }
}