/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.androidos;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class androidOsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Log.d("build","BOARD:" + Build.BOARD);
        Log.d("build","BOOTLOADER:" + Build.BOOTLOADER);	//Android 1.6未対応
        Log.d("build","BRAND:" + Build.BRAND);
        Log.d("build","CPU_ABI:" + Build.CPU_ABI);
        Log.d("build","CPU_ABI2:" + Build.CPU_ABI2);		//Android 1.6未対応
        Log.d("build","DEVICE:" + Build.DEVICE);
        Log.d("build","DISPLAY:" + Build.DISPLAY);
        Log.d("build","FINGERPRINT:" + Build.FINGERPRINT);
        Log.d("build","HARDWARE:" + Build.HARDWARE);		//Android 1.6未対応
        Log.d("build","HOST:" + Build.HOST);
        Log.d("build","ID:" + Build.ID);
        Log.d("build","MANUFACTURER:" + Build.MANUFACTURER);
        Log.d("build","MODEL:" + Build.MODEL);
        Log.d("build","PRODUCT:" + Build.PRODUCT);
        Log.d("build","RADIO:" + Build.RADIO);				//Android 1.6未対応
        Log.d("build","TAGS:" + Build.TAGS);
        Log.d("build","TIME:" + Build.TIME);
        Log.d("build","TYPE:" + Build.TYPE);
        Log.d("build","UNKNOWN:" + Build.UNKNOWN);			//Android 1.6未対応
        Log.d("build","USER:" + Build.USER);
        Log.d("build","VERSION.CODENAME:" + Build.VERSION.CODENAME);
        Log.d("build","VERSION.INCREMENTAL:" + Build.VERSION.INCREMENTAL);
        Log.d("build","VERSION.RELEASE:" + Build.VERSION.RELEASE);
        Log.d("build","VERSION.SDK:" + Build.VERSION.SDK);
        Log.d("build","VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
    }
}