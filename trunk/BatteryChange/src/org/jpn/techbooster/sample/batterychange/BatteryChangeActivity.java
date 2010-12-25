package org.jpn.techbooster.sample.batterychange;

import org.jpn.techbooster.sample.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;

public class BatteryChangeActivity extends Activity {
	private BroadcastReceiver broadcastReceiver_ = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
                // バッテリーの状態
                switch (intent.getIntExtra("health", 0)) {
                case BatteryManager.BATTERY_HEALTH_UNKNOWN:
                    Log.d("BatteryChange", "Health : NKNOWN");
                    break;
                case BatteryManager.BATTERY_HEALTH_DEAD:
                    Log.d("BatteryChange", "Health : DEAD");
                    break;
                case BatteryManager.BATTERY_HEALTH_GOOD:
                    Log.d("BatteryChange", "Health : GOOD");
                    break;
                case BatteryManager.BATTERY_HEALTH_OVERHEAT:
                    Log.d("BatteryChange", "Health : OVERHEAT");
                    break;
                case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:
                    Log.d("BatteryChange", "Health : OVER VOLTAGE");
                    break;
                case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:
                    Log.d("BatteryChange", "Health : UNSPECIFIED FAILURE");
                    break;
                }

                // AC or USB
                switch (intent.getIntExtra("plugged", 0)) {
                case BatteryManager.BATTERY_PLUGGED_AC:
                    Log.d("BT", "Plugged : AC");
                    break;
                case BatteryManager.BATTERY_PLUGGED_USB:
                    Log.d("BT", "Plugged : USB");
                    break;
                }

                // 充電状態
                switch (intent.getIntExtra("status", 0)) {
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    Log.d("BatteryChange", "Status : CHARGING");
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING:
                    Log.d("BatteryChange", "Status : DISCHARGING");
                    break;
                case BatteryManager.BATTERY_STATUS_FULL:
                    Log.d("BatteryChange", "Status : FULL");
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                    Log.d("BatteryChange", "Status : NOT CHARGING");
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    Log.d("BatteryChange", "Status : UNKNOWN");
                    break;
                }
                
                // バッテリーが存在するかどうか
                Log.d("BatteryChange", "Present : " + String.valueOf(intent.getBooleanExtra("present", false)));
                
                // バッテリー残量の最大値
                Log.d("BatteryChange", "Scale : " + String.valueOf(intent.getIntExtra("scale", 0)));

                // バッテリー残量
                Log.d("BatteryChange", "Level : " + String.valueOf(intent.getIntExtra("level", 0)));
                
                // バッテリー電圧 単位：mV
                Log.d("BatteryChange", "Voltage : " + String.valueOf(intent.getIntExtra("voltage", 0)));
                
                // バッテリーの温度 単位：0.1度
                Log.d("BatteryChange", "Temperatue : " + String.valueOf((float)(intent.getIntExtra("temperature", 0)) / 10));
            }
		}
    };
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver_, intentFilter);
    }
}