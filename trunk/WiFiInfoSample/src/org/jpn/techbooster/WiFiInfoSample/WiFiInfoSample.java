package org.jpn.techbooster.WiFiInfoSample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class WiFiInfoSample extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE); // WifiManagerを取得
		WifiInfo w_info = wifiManager.getConnectionInfo(); // WifiInfoのオブジェクトを作成

		// 各種WiFi情報を取得してLogに表示する
		Log.i("WiFiInfoSample", "SSID:" + w_info.getSSID());
		Log.i("WiFiInfoSample", "BSSID:" + w_info.getBSSID());
		Log.i("WiFiInfoSample", "IP Address:" + w_info.getIpAddress());
		Log.i("WiFiInfoSample", "Mac Address:" + w_info.getMacAddress());
		Log.i("WiFiInfoSample", "Network ID:" + w_info.getNetworkId());
		Log.i("WiFiInfoSample", "Link Speed:" + w_info.getLinkSpeed());
	}
}