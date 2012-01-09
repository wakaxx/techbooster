package org.jpn.techbooster.sample.switchpreferencesample;


import com.kobashin.sample.switchpreference.R;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.widget.Toast;

public class SwitchPreferenceSampleActivity extends PreferenceActivity implements OnPreferenceChangeListener{
    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // JavaコードでPreferenceを作成
//        setPreferenceScreen(createPreferenceHierarchy());

        // XMLでPreferenceを作成
        addPreferencesFromResource(R.layout.main);
    }

    private PreferenceScreen createPreferenceHierarchy() {
        // create RootView
        PreferenceScreen rootView = getPreferenceManager().createPreferenceScreen(this);
    	
        // Switch preference
        SwitchPreference switchPref = new SwitchPreference(this);
        switchPref.setKey("switch_preference");
        switchPref.setTitle("Switch Preference Title");
        switchPref.setSummary("Switch Preference Summary");
        
        switchPref.setSwitchTextOff("offだよー");
        switchPref.setSwitchTextOn("onだよー");
        
        switchPref.setOnPreferenceChangeListener(this);
        rootView.addPreference(switchPref);
    	
        
        // Custom Swich Preference 
        MyTwoStatePreference customPref = new MyTwoStatePreference(this);
        customPref.setKey("custom_preference");
        customPref.setTitle("Custom Preference Title");
        customPref.setSummary("Custom Preference Summary");
        rootView.addPreference(customPref);
        
        
        
    	return rootView;
    }

	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {

		// switch changed
		if(preference.getKey().equals("switch_preference")){
			
			// off -> on の時にToastを
			if(newValue == (Object)true){
				Toast.makeText(this, "Changed", Toast.LENGTH_SHORT).show();				
			}

		}

		return true;
	}







}