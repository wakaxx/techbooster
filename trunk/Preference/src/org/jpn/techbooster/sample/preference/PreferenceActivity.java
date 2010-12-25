package org.jpn.techbooster.sample.preference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView.BufferType;

public class PreferenceActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       		
        Button saveButton = (Button)findViewById(R.id.SaveButton);
        saveButton.setOnClickListener(new OnClickListener() {    
			@Override
			public void onClick(View arg0) {
				saveButtonClick();
			}
        });

        Button loadButton = (Button)findViewById(R.id.LoadButton);
        loadButton.setOnClickListener(new OnClickListener() {    
			@Override
			public void onClick(View arg0) {
				loadButtonClick();
			}
        });

    }
    
	private void saveButtonClick() {
		// 保存
		EditText editText = (EditText)findViewById(R.id.EditText01);		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		sp.edit().putString("SaveString", editText.getText().toString()).commit();
	}         
	
	private void loadButtonClick() {
		// 読み込み
		EditText editText = (EditText)findViewById(R.id.EditText01);		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		editText.setText(sp.getString("SaveString", null), BufferType.NORMAL);
	}               
}