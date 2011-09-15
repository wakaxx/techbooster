package org.japan.techbooster.sample.BlueTooth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.telephony.TelephonyManager;
import android.util.Log;
import org.japan.techbooster.sample.BlueTooth.BluetoothClientThread;

public class DeviceListActivity extends Activity {
	
	private BluetoothAdapter mBtAdapter = BlueToothSample.mBtAdapter;
	private ArrayAdapter<String> pairedDeviceAdapter;
	private ArrayAdapter<String> nonPairedDeviceAdapter;
	private ArrayList<BluetoothDevice> foundDeviceList = new ArrayList<BluetoothDevice>();
	
	static int offSet = 0;
	
	public static final String ACTION_DISCOVERY_STARTED = BluetoothAdapter.ACTION_DISCOVERY_STARTED;
	public static final String ACTION_FOUND = BluetoothDevice.ACTION_FOUND;
	public static final String ACTION_NAME_CHANGED = BluetoothDevice.ACTION_NAME_CHANGED;
	public static final String ACTION_DISCOVERY_FINISHED = BluetoothAdapter.ACTION_DISCOVERY_FINISHED;
	
	public String myNumber;
	public Context mContext;
	
 	public static BluetoothClientThread BtClientThread;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.devicelist);
        mContext = this;
        
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        // 電話番号を取得
        myNumber = telephonyManager.getLine1Number();
        if(myNumber == null){
        	myNumber = "09011112222";
        }
        
        //接続履歴のあるデバイスを取得
        pairedDeviceAdapter = new ArrayAdapter<String>(this, R.layout.rowdata);
        //BluetoothAdapterから、接続履歴のあるデバイスの情報を取得
        Set<BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();
        if(pairedDevices.size() > 0){
        	//接続履歴のあるデバイスが存在する
        	for(BluetoothDevice device:pairedDevices){
        		//接続履歴のあるデバイスの情報を順に取得してアダプタに詰める
        		//getName()・・・デバイス名取得メソッド
        		//getAddress()・・・デバイスのMACアドレス取得メソッド
        		pairedDeviceAdapter.add(device.getName() + "\n" + device.getAddress());
        		foundDeviceList.add(device);
        		offSet++;
        	}
        	ListView deviceList = (ListView)findViewById(R.id.pairedDeviceList);
        	deviceList.setAdapter(pairedDeviceAdapter);
        	deviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        		//デバイスリスト選択時の処理
				@Override
				public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
					// TODO Auto-generated method stub
					ListView listView = (ListView) parent;
					BluetoothDevice device = foundDeviceList.get(position);
					BtClientThread = new BluetoothClientThread(mContext, myNumber, device, mBtAdapter);
					BtClientThread.start();
				}
        	});
        }        
    }
    
    @Override
    public void onStart() {
        super.onStart();
    }
    
    @Override
    public void onResume() {
        super.onResume(); 
        //サーバースレッド起動、クライアントのからの要求待ちを開始
		BluetoothServerThread BtServerThread = new BluetoothServerThread(this, myNumber , mBtAdapter); 
		BtServerThread.start();
    }
   
//    @Override
//    public void onPause() {
//        super.onPause(); 
//        if(BtClientThread.){
//        	BtClientThread.cancel();
//        }
//    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	menu.add(0, Menu.FIRST, Menu.NONE, "新規デバイス検出");
		return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	//オプションメニューが選択された時の処理
        //自デバイスの検出を有効にする
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);
        
    	TextView nonPairedListTitle = (TextView)findViewById(R.id.nonPairedListTitle);
    	nonPairedListTitle.setText("接続履歴なしデバイス一覧");
    	
    	if(item.getItemId() == Menu.FIRST){
    		//インテントフィルターとBroadcastReceiverの登録
	        IntentFilter filter = new IntentFilter();
	        filter.addAction(ACTION_DISCOVERY_STARTED);
	        filter.addAction(ACTION_FOUND);
	        filter.addAction(ACTION_NAME_CHANGED);
	        filter.addAction(ACTION_DISCOVERY_FINISHED);
	        registerReceiver(DevieFoundReceiver, filter);
	        
    		nonPairedDeviceAdapter = new ArrayAdapter<String>(this, R.layout.rowdata);
	        //接続可能なデバイスを検出
	        if(mBtAdapter.isDiscovering()){
	        	//検索中の場合は検出をキャンセルする
	        	mBtAdapter.cancelDiscovery();
	        }
	        //デバイスを検索する
	        //一定時間の間検出を行う
	        mBtAdapter.startDiscovery();
    	}
		return false;
    }
    
    private final BroadcastReceiver DevieFoundReceiver = new BroadcastReceiver(){
    	//検出されたデバイスからのブロードキャストを受ける
    	@Override
    	public void onReceive(Context context, Intent intent){
    		String action = intent.getAction();
    		String dName = null;
    		BluetoothDevice foundDevice;

    		ListView nonpairedList = (ListView)findViewById(R.id.nonPairedDeviceList);
    		
    		nonpairedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        		//デバイスリスト選択時の処理
    			@Override
    			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
    				// TODO Auto-generated method stub
    				ListView listView = (ListView) parent;
    				BluetoothDevice device = foundDeviceList.get(offSet + position);
    				BtClientThread = new BluetoothClientThread(mContext, myNumber, device, mBtAdapter);
    				BtClientThread.start();
    			}
        	});
    		
    		if(ACTION_DISCOVERY_STARTED.equals(action)){
    			Log("スキャン開始");
    		}
    		if(ACTION_FOUND.equals(action)){
    			//デバイスが検出された
    			foundDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
    			if((dName = foundDevice.getName()) != null){
		    		if(foundDevice.getBondState() != BluetoothDevice.BOND_BONDED){
		    			//接続したことのないデバイスのみアダプタに詰める
		        		nonPairedDeviceAdapter.add(dName + "\n" + foundDevice.getAddress());  
	        			Log.d("ACTION_FOUND", dName);
	        			//発見されたデバイスをリストに格納しておく
	        			foundDeviceList.add(foundDevice);
		    		}
    			}
            	nonpairedList.setAdapter(nonPairedDeviceAdapter);
    		}    
    		if(ACTION_NAME_CHANGED.equals(action)){
    			//名前が検出された
    			Log.d("ACTION_NAME_CHANGED", dName);
    			foundDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	    		if(foundDevice.getBondState() != BluetoothDevice.BOND_BONDED){
	    			//接続したことのないデバイスのみアダプタに詰める
	        		nonPairedDeviceAdapter.add(dName + "\n" + foundDevice.getAddress());    				
	    		}
            	nonpairedList.setAdapter(nonPairedDeviceAdapter);
    		}

    		if(ACTION_DISCOVERY_FINISHED.equals(action)){
    			Log("スキャン終了");
    		}
    	}
    };
    
	public void sockClose() {
		BtClientThread.cancel();
    }
	
    public void Log(String string){
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();    	
    }
}
