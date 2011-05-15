package org.jpn.techbooster.sample.LocationManagerSample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.widget.Toast;

public class ReceiveLocation extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		if(intent.hasExtra(LocationManager.KEY_LOCATION_CHANGED)){
			LocationManager lm = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);

			Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

			String message = "Location\n"
			                  + "Longitude：" + location.getLongitude() + "\n"
			                  + "Latitude：" + location.getLatitude();

			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		}
	}
}
