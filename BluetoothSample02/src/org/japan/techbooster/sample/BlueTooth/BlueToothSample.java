package org.japan.techbooster.sample.BlueTooth;

import java.util.List;
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
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class BlueToothSample extends Activity {
    /** Called when the activity is first created. */
	
	static BluetoothAdapter mBtAdapter;
	int REQUEST_ENABLE_BLUETOOTH = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        boolean suportRet = supportConfirm();
        if(suportRet == false){
        	//非サポートだった場合
        	Toast.makeText(this, "BT非サポ", Toast.LENGTH_SHORT).show();
        	finish();
        }else{
	        Toast.makeText(this, "BTサポートされてます", Toast.LENGTH_SHORT).show();
	        
	        //BluetoothがOnかOffか判断する
	        //Offだった場合はダイアログ表示してONにするよう促す
	        boolean btEnabledRet = OnOffConfirm();
	        if(btEnabledRet == false){
	        	//Offだった場合
	        	//Intent投げたあと、ONにする前にこの処理に入るため、ONにした後の処理はここに書かない。
	        }
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
    	boolean btEnable = mBtAdapter.isEnabled();
    	if(btEnable == true){
    		Intent intent = new Intent(getApplicationContext(), DeviceListActivity.class);
    		startActivity(intent);        		
    		return true;
    	}
    	//Onでない場合、Onにするためのダイアログを表示する
    	Intent BtOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
    	startActivityForResult(BtOn, REQUEST_ENABLE_BLUETOOTH);
    	return false;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int ResultCode, Intent date){
    	if(requestCode == REQUEST_ENABLE_BLUETOOTH){
    		if(ResultCode == Activity.RESULT_OK){
    			//BluetoothがOnだった場合の処理
    			Log("BTがOnになりました");
    			//ペアリング画面に遷移する
        		Intent intent = new Intent(getApplicationContext(), DeviceListActivity.class);
        		startActivity(intent);        		
    		}else{
    			Log("BTがOnにしてもらえませんでした");
    		}
    	}
    }
    
    public void Log(String string){
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();    	
    }
}