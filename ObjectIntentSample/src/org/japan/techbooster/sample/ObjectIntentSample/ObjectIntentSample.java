package org.japan.techbooster.sample.ObjectIntentSample;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import org.japan.techbooster.sample.*;

public class ObjectIntentSample extends Activity {

	EditText eng;
    EditText math ;
    EditText science;
    EditText social;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        eng = (EditText)findViewById(R.id.eng);
        math = (EditText)findViewById(R.id.math);
        science = (EditText)findViewById(R.id.science);
        social = (EditText)findViewById(R.id.social);
        

        
        Button saveBtn = (Button)findViewById(R.id.save);
        saveBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
		        String Str = eng.getText().toString();
		        double engPnt = Double.valueOf(Str);
		        Str = eng.getText().toString();
		        double mathPnt = Double.valueOf(Str);
		        Str = science.getText().toString();
		        double sciencePnt = Double.valueOf(Str);
		        Str = social.getText().toString();
		        double socialPnt = Double.valueOf(Str);
		        
				TestResults tr = new TestResults((int)engPnt,(int)mathPnt,(int)sciencePnt,(int)socialPnt);
				
				Intent objIntent = new Intent(getApplicationContext(),RecieveActiviity.class);
				objIntent.putExtra("test_result",tr);
				startActivity(objIntent);
			}
        	
        });
    }
}