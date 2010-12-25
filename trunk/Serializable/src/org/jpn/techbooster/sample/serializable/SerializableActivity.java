package org.jpn.techbooster.sample.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.jpn.techbooster.sample.serializable.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SerializableActivity extends Activity implements OnClickListener {
	static final private String TAG = "Serializable";
	private Button buttonSave_;
	private Button buttonLoad_;
	private EditText editTextString_;
	private EditText editTextNumber_;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        buttonSave_ = (Button)findViewById(R.id.ButtonSave);
        buttonSave_.setOnClickListener(this);
        buttonLoad_ = (Button)findViewById(R.id.ButtonLoad);
        buttonLoad_.setOnClickListener(this);
        editTextString_ = (EditText)findViewById(R.id.EditTextString);
        editTextNumber_ = (EditText)findViewById(R.id.EditTextNumber);
    }

	@Override
	public void onClick(View view) {
		if (buttonSave_ == view) {
			SerializableData data = new SerializableData();
			data.setString(editTextString_.getText().toString());
			if (0 != editTextNumber_.length()) {
				data.setNumber(Integer.parseInt(editTextNumber_.getText().toString()));
			} else {
				data.setNumber(0);
			}
			try {
				FileOutputStream fos = openFileOutput("SaveData.dat", MODE_PRIVATE);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(data);
				oos.close();
			} catch (Exception e) {
				Log.d(TAG, "Error");
			}
		} else if (buttonLoad_ == view) {
			try {
				FileInputStream fis = openFileInput("SaveData.dat");
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        SerializableData data = (SerializableData) ois.readObject();
		        ois.close();
		        editTextString_.setText(data.getString());
		        editTextNumber_.setText(Integer.toString(data.getNumber()));
			} catch (Exception e) {
				Log.d(TAG, "Error");
			}
		}
	}
}