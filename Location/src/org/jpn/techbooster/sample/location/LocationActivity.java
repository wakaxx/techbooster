package org.jpn.techbooster.sample.location;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.util.Log;
import android.widget.TextView;

public class LocationActivity extends Activity implements LocationListener {
	private LocationManager locationManager_;
	private LocationProvider locationProvider_;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public void onStart() {
    	super.onStart();

    	TextView providerLabel = (TextView)findViewById(R.id.ProviderLabel);
          	
    	// ロケーションマネージャのインスタンスを取得する
    	locationManager_ = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    	
    	// プロバイダにGPSを設定
    	locationProvider_ = locationManager_.getProvider(LocationManager.GPS_PROVIDER);
    	
    	if (null == locationProvider_) {
            // GPSが使えない場合、ネットワークからの位置情報取得を設定する
            locationProvider_ = locationManager_.getProvider(LocationManager.NETWORK_PROVIDER);
            if (null == locationProvider_) {
            	return;
            } else {
           		providerLabel.setText("NETWORK_PROVIDER");            	
            }
    	} else {
    		providerLabel.setText("GPS_PROVIDER");
    	}
    	
    	// 位置情報の更新を受け取るように設定
    	locationManager_.requestLocationUpdates(locationProvider_.getName(),
    											0,
    											0,
    											this);
    }
    
    @Override
    public void onStop() {
    	super.onStop();
    	
    	// 位置情報の更新を止める
    	locationManager_.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
    	// 位置情報をTextViewに設定する
    	TextView latitudeLabel = (TextView)findViewById(R.id.LatitudeLabel);
    	TextView LongitudeLabel = (TextView)findViewById(R.id.LongitudeLabel);
          	
    	latitudeLabel.setText(Double.toString(location.getLatitude()));
    	LongitudeLabel.setText(Double.toString(location.getLongitude()));
    }
    
    @Override
    public void onProviderEnabled(String provider) {
    	Log.d("LocationActivity","onProviderEnabled");
    }
    
    @Override
    public void onProviderDisabled(String provider) {   
    	Log.d("LocationActivity","onProviderDisabled");
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
       	Log.d("LocationActivity","onStatusChanged");   	
    }
}