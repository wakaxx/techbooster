package org.jpn.techbooster.sample.hardwareKeyActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class HardwareKeyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {

       // DOWNとUPが取得できるのでログの2重表示防止のためif
       if (e.getAction() == KeyEvent.ACTION_DOWN) {
    	   //キーコード表示
    	   Log.d("KeyCode","KeyCode:"+ e.getKeyCode());
       }

       return super.dispatchKeyEvent(e);
    }
}