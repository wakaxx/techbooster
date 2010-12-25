package org.jpn.techbooster.sample.sdcard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.jpn.techbooster.sample.sdcard.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SdcardActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button buttonSave = (Button)findViewById(R.id.ButtonSave);
        buttonSave.setOnClickListener(new OnClickListener(){  
			@Override
			public void onClick(View arg0) {
				String filePath = Environment.getExternalStorageDirectory() + "/memo.txt";
				File file = new File(filePath);  
				file.getParentFile().mkdir();  

				FileOutputStream fos;
				try {
					fos = new FileOutputStream(file, true);
					OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");  
					BufferedWriter bw = new BufferedWriter(osw);  
					String str = ((EditText) findViewById(R.id.EditTextInput)).getText().toString();
					bw.write(str);  
					bw.flush();  
					bw.close(); 
				} catch (Exception e) {
				}  
			}; 
        });
    }
}