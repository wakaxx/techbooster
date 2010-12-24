package org.jpn.techbooster.VersionSetting;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class VersionSetting extends Activity {
	/** Called when the activity is first created. */
	PackageInfo packageInfo = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView tv = (TextView) findViewById(R.id.TextView);

		try {
			// getScreenSizeアプリケーションのヴァージョンを取得する
			// (2010.08.14「画面サイズを取得する」で紹介したサンプル)
			packageInfo = getPackageManager().getPackageInfo(
					"org.jpn.techbooster.getScreenSize",
					PackageManager.GET_META_DATA);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ヴァージョン情報を表示
		tv.setText("versionCode : " + packageInfo.versionCode + " / "
				+ "versionName : " + packageInfo.versionName);
	}
}