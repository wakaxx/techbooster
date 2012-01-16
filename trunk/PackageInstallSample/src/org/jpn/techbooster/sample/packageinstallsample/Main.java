package org.jpn.techbooster.sample.packageinstallsample;

import org.jpn.techbooster.sample.sample.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Main extends Activity {
	public static final int PREFERENECE_INIT = 0;
	public static final int PREFERENECE_BOOTED = 1;
	public static final int PREFERENECE_UPDATE = 2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		myVersionCheck();
		
	}

	@Override
	public void onResume() {
		super.onResume();

	}

	private void myVersionCheck() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = sp.edit();
		int vCode = sp.getInt("VersionCode", 1);
		String vName = sp.getString("VersionName", "1.0");

		PackageInfo pi = null;
		try {
			pi = getPackageManager().getPackageInfo(getPackageName(),
					PackageManager.GET_META_DATA);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		if (pi != null) {
			// VersionCode ��VersionUP�𔻒f����
			if (pi.versionCode > vCode) {
				Toast.makeText(this, "Version Up @VersionCode Change to "+Integer.toString(pi.versionCode),
						Toast.LENGTH_LONG).show();
			}
			// VersionName ��VersionUP�𔻒f����
			if (!pi.versionName.equals(vName)) {
				Toast.makeText(this, "Version Up @VersionName Change to "+pi.versionName,
						Toast.LENGTH_LONG).show();
			}
		}

		//���݂�Version����Preference�ɕۑ�
		editor.putInt("VersionCode",pi.versionCode);
		editor.putString("VersionName",pi.versionName);
		editor.commit();
	}

}