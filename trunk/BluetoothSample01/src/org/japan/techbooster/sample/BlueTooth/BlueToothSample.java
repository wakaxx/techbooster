package org.japan.techbooster.sample.BlueTooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BlueToothSample extends Activity {
    /** Called when the activity is first created. */
	
	public BluetoothAdapter mBtAdapter;
	public int REQUEST_ENABLE_BLUETOOTH = 0;
	public boolean OnOffRet;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        boolean suportRet = supportConfirm();
        if(suportRet == true){
        	//Bluetooth対応端末の場合の処理
        	Toast.makeText(this, "BTサポートされてます", Toast.LENGTH_SHORT).show();
            OnOffRet = OnOffConfirm();
        }else{
        	//Bluetooth非対応端末の場合の処理
        	Toast.makeText(this, "BT非サポ", Toast.LENGTH_SHORT).show();
        	finish();
        }
    }
    
    private boolean supportConfirm(){
        //Bluetoothがサポートされているか否かを確かめる
        BluetoothAdapter Bt = BluetoothAdapter.getDefaultAdapter();
        if(Bt.equals(null)){
        	return false;
        }
        mBtAdapter = Bt;
        return true;
    }
    
    private boolean OnOffConfirm(){
    	//BluetoothがOnになっているかどうかを確かめる
    	boolean OnOff = mBtAdapter.isEnabled();
    	if(OnOff == true){
    		//BluetoothがOnにされた場合の処理
    		return true;
    	}else{
	    	//Onでない場合、Onにするためのダイアログを表示する
	    	Intent BtOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	    	startActivityForResult(BtOn, REQUEST_ENABLE_BLUETOOTH);
	    	return false;
    	}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int ResultCode, Intent date){
    	if(requestCode == REQUEST_ENABLE_BLUETOOTH){
    		if(ResultCode == Activity.RESULT_OK){
    			//BluetoothがOnにされた場合の処理
    			Toast.makeText(this, "BTがOnになりました", Toast.LENGTH_SHORT).show();
    		}else{
    			//BluetoothがOnにされなかった場合の処理
    			Toast.makeText(this, "BTがOnにしてもらえませんでした", Toast.LENGTH_SHORT).show();
            	finish();
    		}
    	}
    }
}