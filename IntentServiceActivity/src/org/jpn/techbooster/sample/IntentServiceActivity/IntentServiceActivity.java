/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.IntentServiceActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class IntentServiceActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //MyIntentServiceを起動する
    	Intent intent = new Intent(this, MyIntentService.class);
    	intent.putExtra("IntentServiceCommand","TestText");

    	this.startService(intent);

    }
}