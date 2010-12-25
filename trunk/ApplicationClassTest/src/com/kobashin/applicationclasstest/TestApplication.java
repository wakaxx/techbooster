package com.kobashin.applicationclasstest;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.Log;

public class TestApplication extends Application {
	private final String TAG = "DEBUG-APPLICATION";
	private Bitmap obj;
	
	@Override
    public void onCreate() {
	    /** Called when the Application-class is first created. */
		Log.v(TAG,"--- onCreate() in ---");
	}

    @Override
    public void onTerminate() {
    	/** This Method Called when this Application finished. */
		Log.v(TAG,"--- onTerminate() in ---");
    }

    public void setObj(Bitmap bmp){
    	obj = bmp;
    }
    
    public Bitmap getObj(){
    	return obj;
    }
}