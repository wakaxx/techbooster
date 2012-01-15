package org.jpn.techbooster.Gps;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class GpsActivity extends Activity implements LocationListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        LocationManager mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
		Criteria criteria = new Criteria();

		//Accuracyを指定
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);
		
		//PowerRequirementを指定
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		
		//SpeedRequiredを指定
		criteria.setSpeedRequired(false);
		
		//AltitudeRequiredを指定
		criteria.setAltitudeRequired(false);
		
		//BearingRequiredを指定
		criteria.setBearingRequired(false);
		
		//CostAllowedを指定
		criteria.setCostAllowed(false);
		
		String provider = mLocationManager.getBestProvider(criteria, true);

		// 取得したロケーションプロバイダを表示
		TextView tv_provider = (TextView) findViewById(R.id.Provider);
		tv_provider.setText("Provider: "+provider);
		
		mLocationManager.requestLocationUpdates(provider, 0, 0, this);
    }

	@Override
	public void onLocationChanged(Location location) {
		TextView tv_lng = (TextView) findViewById(R.id.Longitude);
		tv_lng.setText("Latitude:"+location.getLongitude());
		TextView tv_lat = (TextView) findViewById(R.id.Latitude);
		tv_lat.setText("Latitude:"+location.getLatitude());
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}
