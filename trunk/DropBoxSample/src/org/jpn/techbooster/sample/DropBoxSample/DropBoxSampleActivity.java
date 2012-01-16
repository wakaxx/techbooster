package org.jpn.techbooster.sample.DropBoxSample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DropBoxSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button bt = (Button) findViewById(R.id.auth);
        bt.setOnClickListener(new OnClickListener() {
            
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), DropBoxAuthActivity.class);
                startActivity(intent);
            }
        });
    }
}