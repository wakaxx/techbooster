/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class subActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        Intent intent = getIntent();

        if(intent != null){

        	String str = intent.getStringExtra("org.jpn.techbooster.demo.intent.testString");

        	Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        }
    }
}