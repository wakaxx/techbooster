package org.jpn.techbooster.PreferenceSample;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.util.Log;

public class PreferenceSample extends PreferenceActivity implements OnSharedPreferenceChangeListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences); // preference.xmlを読み込む
	}

	// Preferenceの内容が変更された場合に呼ばれる
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		Log.i("PreferenceSample", "onSharedPreferenceChanged()");
		updatePreference(); // Sammuryに現在の設定値を表示する関数を呼び出す
	}

	@Override
	protected void onResume() {
		super.onResume();
		// Set up a listener whenever a key changes
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// Unregister the listener whenever a key changes
		getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
	}

	// Sammuryに現在の設定値を表示する
	public void updatePreference() {
		// CheckBoxPreferenceの値をSammuryに表示する
		CheckBoxPreference checkbox_preference = (CheckBoxPreference) getPreferenceScreen().findPreference("checkbox_preference");
		if (checkbox_preference.isChecked()) {
			checkbox_preference.setSummary("ture");
		} else {
			checkbox_preference.setSummary("false");
		}

		// EditTextPreferenceの値をSammuryに表示する
		EditTextPreference edittext_preference = (EditTextPreference) getPreferenceScreen().findPreference("edittext_preference");
		edittext_preference.setSummary(edittext_preference.getText());

		// ListPreferenceの値をSammuryに表示する
		ListPreference list_preference = (ListPreference) getPreferenceScreen().findPreference("list_preference");
		list_preference.setSummary(list_preference.getValue());
	}
}
