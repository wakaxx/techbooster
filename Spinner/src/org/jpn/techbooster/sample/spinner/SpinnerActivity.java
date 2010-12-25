package org.jpn.techbooster.sample.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends Activity {
	private Spinner selectSpinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Spinnerの設定
        ArrayAdapter<CharSequence> adapter = 
        	ArrayAdapter.createFromResource(this, R.array.sample_array, 
        									android.R.layout.simple_spinner_item);
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        	    this, android.R.layout.simple_spinner_item);
		adapter.add("Sample0");
		adapter.add("Sample1");
		adapter.add("Sample2");
		adapter.add("Sample3");
		adapter.add("Sample4");
        */	
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        selectSpinner = (Spinner) findViewById(R.id.Spinner01);
        selectSpinner.setAdapter(adapter);
        selectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
				showToast(Integer.toString(spinner.getSelectedItemPosition()));
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        
        // ボタンの設定
        Button buttonCheckSelected;
        buttonCheckSelected = (Button)findViewById(R.id.ButtonCheckSelected);
        buttonCheckSelected.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				showToast((String)selectSpinner.getSelectedItem());
			}
        });
    }
    
    private void showToast(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}