package org.jpn.techbooster.sample.wakelocksample;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WakeLockService extends Service {

	/** Called when the activity is first created. */
	@Override
	public void onCreate() {
		super.onCreate();

		/* BackGroundÇ©ÇÁÇÃèàóù */
		PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
		PowerManager.WakeLock wakelock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK
				| PowerManager.ACQUIRE_CAUSES_WAKEUP
				| PowerManager.ON_AFTER_RELEASE, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		wakelock.acquire();
		wakelock.release();
		
		// Decide which activity to start based on the state of the keyguard.
		KeyguardManager km = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
		KeyguardManager.KeyguardLock klock = km.newKeyguardLock("TAG");
		klock.disableKeyguard();
		
		/* WakeUpå„ÇÃActivityÇÃêÿÇËë÷Ç¶ */
		Intent wakeUpIntent = new Intent(this, PopUpActivity.class);
		wakeUpIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_NO_USER_ACTION);
		this.startActivity(wakeUpIntent);


		
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
