package org.jpn.techbooster.PreferenceSample2;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceClickListener;

public class PreferenceCustomSampleActivity extends PreferenceActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		addPreferencesFromResource(R.xml.preference);

		// PreferenceScreenからのIntent
		PreferenceScreen nextMove1 = (PreferenceScreen) findPreference("preferenceKey1");
		nextMove1.setOnPreferenceClickListener(new OnPreferenceClickListener() {
			@Override
			public boolean onPreferenceClick(Preference preference) {

				// Activityの遷移
				Intent nextActivity = new Intent(
						PreferenceCustomSampleActivity.this,
						org.jpn.techbooster.PreferenceSample2.Sample2Activity.class);
				
				startActivity(nextActivity);
				return true;
			}
		});

	}
}