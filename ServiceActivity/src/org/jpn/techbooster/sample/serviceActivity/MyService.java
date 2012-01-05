package org.jpn.techbooster.sample.serviceActivity;

import android.app.Service;
import android.content.Intent;import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

	static final String TAG="LocalService";

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
    	Toast.makeText(this, "MyService#onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand Received start id " + startId + ": " + intent);
    	Toast.makeText(this, "MyService#onStartCommand", Toast.LENGTH_SHORT).show();
        //明示的にサービスの起動、停止が決められる場合の返り値
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
    	Toast.makeText(this, "MyService#onDestroy", Toast.LENGTH_SHORT).show();
    }

    /*
     * 以下はBind時に必要なコード
     * */

    //サービスに接続するためのBinder
    public class MyServiceLocalBinder extends Binder {
		//サービスの取得
    	MyService getService() {
            return MyService.this;
        }
    }
    //Binderの生成
    private final IBinder mBinder = new MyServiceLocalBinder();

	@Override
	public IBinder onBind(Intent intent) {
    	Toast.makeText(this, "MyService#onBind"+ ": " + intent, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onBind" + ": " + intent);
		return mBinder;
	}

	@Override
	public void onRebind(Intent intent){
    	Toast.makeText(this, "MyService#onRebind"+ ": " + intent, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRebind" + ": " + intent);
	}

	@Override
	public boolean onUnbind(Intent intent){
    	Toast.makeText(this, "MyService#onUnbind"+ ": " + intent, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onUnbind" + ": " + intent);

        //onUnbindをreturn trueでoverrideすると次回バインド時にonRebildが呼ばれる
		return true;
	}
}