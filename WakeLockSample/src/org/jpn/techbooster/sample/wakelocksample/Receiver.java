package org.jpn.techbooster.sample.wakelocksample;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String act = intent.getAction();
			Intent sintent = new Intent(context,WakeLockService.class);
			context.startService(sintent);
	}

}
