package org.jpn.techbooster.AlarmSample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceivedActivity extends BroadcastReceiver {
	public void onReceive(Context context, Intent intent) {
		// Toastを表示する
		Toast.makeText(context, "called ReceivedActivity", Toast.LENGTH_SHORT).show();
	}
}
