package org.techbooster.sample.Intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SubActivity  extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
        
        Intent intent = getIntent();
        if(intent != null){
            String str = intent.getStringExtra("org.techbooster.sample.Intent.testString");
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        } 
    }
}
