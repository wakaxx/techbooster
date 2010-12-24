package org.jpn.techbooster.PreferenceSample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class ValueCheck extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView result_cb = (TextView)findViewById(R.id.result_cb);
        TextView result_et = (TextView)findViewById(R.id.result_et);
        TextView result_list = (TextView)findViewById(R.id.result_list);
        
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checkbox_preference = sharedPreferences.getBoolean("checkbox_preference", false);
		if (checkbox_preference) {
			result_cb.setText("TRUE");
		} else {
			result_cb.setText("FALSE");
		}

		String edittext_preference = sharedPreferences.getString("edittext_preference", "unknown");
		result_et.setText(edittext_preference);

		String list_preference = sharedPreferences.getString("list_preference", "unknown");
		result_list.setText(list_preference);
    }
}
