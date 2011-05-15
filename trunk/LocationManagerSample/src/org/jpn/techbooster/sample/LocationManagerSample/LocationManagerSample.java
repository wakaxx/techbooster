package org.jpn.techbooster.sample.LocationManagerSample;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;

public class LocationManagerSample extends Activity{
	private LocationManager lm;
	private PendingIntent pi;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //LocationManagerオブジェクトの生成
        lm = (LocationManager)getSystemService(LOCATION_SERVICE);

        //ローケーション取得条件の設定
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setSpeedRequired(false);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);

        //PendingIntentの生成
        Intent nextIntent = new Intent(this, ReceiveLocation.class);
        pi = PendingIntent.getBroadcast(this, 0x432f, nextIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        lm.requestLocationUpdates(1000, 1, criteria, pi);

    }

    @Override
    protected void onPause() {
    	super.onPause();

    	lm.removeUpdates(pi);
    }
}