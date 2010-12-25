package org.jpn.techbooster.sample.actionsend;

import org.jpn.techbooster.sample.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActionSendActivity extends Activity {
	static final private String TAG = "ActionSendActivity";	
	private EditText editText_;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editText_ = (EditText)findViewById(R.id.Text);
        
        Button sendButton = (Button)findViewById(R.id.SendButton);
        sendButton.setOnClickListener(new OnClickListener() {    
			@Override
			public void onClick(View view) {
				try {
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_SEND);
					intent.setType("text/plain"); 
					intent.putExtra(Intent.EXTRA_TEXT, editText_.getText().toString());
					startActivity(intent);
				} catch (Exception e) {
					Log.d(TAG, "Error");
				}
			}
        });
        
        Intent intent = getIntent();
        String action = intent.getAction();
        if (Intent.ACTION_SEND.equals(action)) {
        	Bundle extras = intent.getExtras();
        	if (extras != null) {
        		CharSequence ext = extras.getCharSequence(Intent.EXTRA_TEXT);
        		if (ext != null) {
        			editText_.setText(ext);
        		}
        	}
        }
    }
}