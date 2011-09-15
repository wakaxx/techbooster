package org.japan.techbooster.sample.BlueTooth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class StreamActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.streamactivity);
        
        Intent intent = getIntent();
        String number = intent.getStringExtra("NUMBER");
        
        EditText eText = (EditText)findViewById(R.id.phone_num);
        eText.setText(number);
    }
}
