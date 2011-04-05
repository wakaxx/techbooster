package org.jpn.techbooster.sample.toggleDeviceActivity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class toggleDeviceActivity extends Activity {
    /** Called when the activity is first created. */

    static final int REQUEST_ENABLE_BT = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        //toggleボタンにwifiの現在の有効/無効を反映
        ToggleButton tb = (ToggleButton) findViewById(R.id.ToggleButtonWifi);
        WifiManager wifi = (WifiManager) getSystemService(WIFI_SERVICE);
        tb.setChecked( wifi.isWifiEnabled() );

        //ToggleのCheckが変更したタイミングで呼び出し
        tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//トグルキーが変更された際に呼び出される
				Log.d("ToggleButton","call Wifi OnCheckdChangeListener");

				//Wifi有効、無効切り替え
		        WifiManager wifi = (WifiManager) getSystemService(WIFI_SERVICE);
				wifi.setWifiEnabled(isChecked);
			}
		});

        //toggleボタンにBluetoothの現在の有効/無効を反映
        tb = (ToggleButton) findViewById(R.id.ToggleButtonBluetooth);
        BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
        tb.setChecked(ba.isEnabled());

        //ToggleのCheckが変更したタイミングで呼び出し
        tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//トグルキーが変更された際に呼び出される
				Log.d("ToggleButton","call Bluetooth OnCheckdChangeListener");

				//Wifi有効、無効切り替え
		        BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
		        if(isChecked){
		        	//ba.enable();
		        	Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		        	startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		        }else{
		        	ba.disable();
		        }
			}
		});


    }
}