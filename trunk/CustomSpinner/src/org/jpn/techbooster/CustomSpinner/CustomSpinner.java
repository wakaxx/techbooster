package org.jpn.techbooster.CustomSpinner;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CustomSpinner extends Activity {
	/** Called when the activity is first created. */

	Spinner selectSpinner;
	TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Adapterの作成
		ArrayAdapter adapter = new ArrayAdapter(this,	android.R.layout.simple_spinner_item);
		adapter.add("Sample0");
		adapter.add("Sample1");
		adapter.add("Sample2");
		adapter.add("Sample3");
		adapter.add("Sample4");
		adapter.setDropDownViewResource(R.layout.my_dropdown_style);

		// Spinnerを作成
		selectSpinner = (Spinner) findViewById(R.id.Spinner01);
		// SpinnerにAdapterを登録
		selectSpinner.setAdapter(adapter);

		// Spinner上の項目が選択されたときに呼ばれる
		selectSpinner
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						Spinner spinner = (Spinner) parent;
						String str = (String) spinner.getSelectedItem();
						Log.i("CustomSpinner", str);
					}

					public void onNothingSelected(AdapterView<?> parent) {
						//
					}
				});
	}
}
