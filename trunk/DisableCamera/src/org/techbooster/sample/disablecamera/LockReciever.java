package org.techbooster.sample.disablecamera;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LockReciever extends DeviceAdminReceiver {
	
	 @Override
	    public void onEnabled(Context context, Intent intent) {
		 Log.i("seit", "onEnabled!");
	    }

	    @Override
	    public void onDisabled(Context context, Intent intent) {
			 Log.i("seit", "onDisabled!");
	    }

}
