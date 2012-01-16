package org.jp.techbooster.sample.tcblivewallpaper2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;



public class SettingSample extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.prefsetting);
    
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    }
}
