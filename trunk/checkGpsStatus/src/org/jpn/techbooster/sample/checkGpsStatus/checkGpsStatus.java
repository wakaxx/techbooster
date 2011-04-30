package org.jpn.techbooster.sample.checkGpsStatus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.provider.Settings.Secure;

public class checkGpsStatus extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn_checkGps = (Button) findViewById(R.id.btn_checkGps);
		btn_checkGps.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// GPSの状態を取得
				String gpsStatus = android.provider.Settings.Secure
						.getString(getContentResolver(), Secure.LOCATION_PROVIDERS_ALLOWED);

				Log.i("settingSystem", "gpsStatus:" + gpsStatus);

				// GPSが無効だった場合
				if (gpsStatus.indexOf("gps", 0) < 0) {
					// Toastを表示
					Toast.makeText(getApplicationContext(), "GPSは無効です",
							Toast.LENGTH_LONG).show();

					// GPSが有効だった場合
				} else {
					// Toastを表示
					Toast.makeText(getApplicationContext(), "GPSは有効です",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}