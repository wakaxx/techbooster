package org.jpn.techbooster.sample.telephonymanager;

import org.jpn.techbooster.sample.R;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class TelephonyManagerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        Log.d("TM", "Line1Number " + telephonyManager.getLine1Number());
        Log.d("TM", "DeviceId " + telephonyManager.getDeviceId());
        Log.d("TM", "SimCountryIso " + telephonyManager.getSimCountryIso());
        Log.d("TM", "SimOperator " + telephonyManager.getSimOperator());
        Log.d("TM", "SimOperatorName " + telephonyManager.getSimOperatorName());
        Log.d("TM", "SimSerialNumber " + telephonyManager.getSimSerialNumber());
        Log.d("TM", "SimState " + telephonyManager.getSimState());
        Log.d("TM", "VoiceMailNumber " + telephonyManager.getVoiceMailNumber());

    }
}