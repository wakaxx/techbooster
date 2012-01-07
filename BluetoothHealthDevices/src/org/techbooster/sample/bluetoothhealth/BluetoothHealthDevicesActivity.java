package org.techbooster.sample.bluetoothhealth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHealth;
import android.bluetooth.BluetoothHealthAppConfiguration;
import android.bluetooth.BluetoothHealthCallback;
import android.bluetooth.BluetoothProfile;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;

public class BluetoothHealthDevicesActivity extends Activity {


    BluetoothHealth mBluetoothHealth;
    BluetoothHealthAppConfiguration mHealthConfig;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        // デフォルトアダプタからヘルスデバイスへの接続権を取得する
        mBluetoothAdapter.getProfileProxy(getApplicationContext(), mProfileListener, BluetoothProfile.HEALTH);

    }

    private BluetoothProfile.ServiceListener mProfileListener = new BluetoothProfile.ServiceListener() {
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == BluetoothProfile.HEALTH) {
                //ヘルスデバイスが検出された
                mBluetoothHealth = (BluetoothHealth) proxy;
            }
        }
        public void onServiceDisconnected(int profile) {
            if (profile == BluetoothProfile.HEALTH) {
                //ヘルスデバイスが切断された
                mBluetoothHealth = null;
            }
        }
    };


	private BluetoothDevice mBluetoothDevice;
	private int mChannelId;

	private void registerHealthDevices(){

    	MyBluetoothHealthCallback mCallback = new MyBluetoothHealthCallback();

    	mBluetoothHealth.registerSinkAppConfiguration("HEALTH_DEVICES",BluetoothHealth.SINK_ROLE, mCallback);

    }

	class MyBluetoothHealthCallback extends BluetoothHealthCallback {

		@Override
		public void onHealthAppConfigurationStatusChange(
				BluetoothHealthAppConfiguration config, int status) {
			super.onHealthAppConfigurationStatusChange(config, status);

			// TODO : 接続したいヘルスデバイス(3rdパーティ製品など)のconfigを覚える
			mHealthConfig = config;
		}

		@Override
		public void onHealthChannelStateChange(
				BluetoothHealthAppConfiguration config, BluetoothDevice device,
				int prevState, int newState, ParcelFileDescriptor fd, int channelId) {

			super.onHealthChannelStateChange(config, device, prevState,
					newState, fd, channelId);

			// TODO: ヘルスデバイスの状態変更通知
			mChannelId = channelId;
		}
	};

	private void unregisterHealthDevices(){
		mBluetoothHealth.unregisterAppConfiguration(mHealthConfig);
	}


	private void connect(){
		//Bluetoothデバイスに、コンフィグを使って接続する
		mBluetoothHealth.connectChannelToSource(mBluetoothDevice, mHealthConfig);
	}

	private void disconnect(){
		//ヘルスデバイスと切断
		mBluetoothHealth.disconnectChannel(mBluetoothDevice, mHealthConfig, mChannelId);

	}
}