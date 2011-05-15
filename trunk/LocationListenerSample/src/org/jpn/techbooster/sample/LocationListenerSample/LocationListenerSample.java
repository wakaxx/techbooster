package org.jpn.techbooster.sample.LocationListenerSample;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class LocationListenerSample extends Activity implements
		LocationListener {
	private LocationManager lm;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// LocationManagerオブジェクトの生成
		lm = (LocationManager) getSystemService(LOCATION_SERVICE);

		// ローケーション取得条件の設定
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		criteria.setSpeedRequired(false);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(false);

		lm.requestLocationUpdates(1000, 1, criteria, this, this
						.getMainLooper());

	}

	// 位置情報が変更された場合に呼び出される
	@Override
	public void onLocationChanged(Location loc) {
		this.display(loc);
	}

	// LocationProviderが有効になった場合に呼び出される
	@Override
	public void onProviderDisabled(String provider) {
	}

	// LocationProviderが無効になった場合に呼び出される
	@Override
	public void onProviderEnabled(String provider) {
	}

	// LocationProviderの状態が変更された場合に呼び出される
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	private void display(Location loc) {
		String message = "Location\n" + "Longitude：" + loc.getLongitude()
				+ "\n" + "Latitude：" + loc.getLatitude();

		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}

}