package org.jpn.techbooster.sample.threadproc;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class ThreadActivity extends Activity implements Runnable {

	private Thread mLooper;
	private Handler mHandler;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final TextView tv = (TextView)findViewById(R.id.textview);

        mHandler =  new Handler(){
        	//メッセージ受信
    		public void handleMessage(android.os.Message message) {
    			//メッセージの表示
    			tv.setText((String) message.obj);
    			//メッセージの種類に応じてswitch文で制御すれば
    			//イベント制御に利用できます
    		};
    	};
    }

    @Override
    public void onStart(){
    	super.onStart();

        mLooper = new Thread(this);
        //スレッド処理を開始
        if(mLooper != null ){
            mLooper.start();
        }
    }

    @Override
    public void onStop(){
    	super.onStop();
    	//スレッドを削除
        mLooper = null;
    }

  //スレッドによる更新処理
	public void run() {
		long time = System.currentTimeMillis();
		long count = 0;

		while (mLooper != null) {

			long now = System.currentTimeMillis();
			if(now - time > 1000){

            	//Message msg = new Message();
				//Message msg = Message.obtain();
				Message msg = mHandler.obtainMessage();

            	msg.obj = new String("ループが"+ count + "回終了しました");

				//ハンドラへのメッセージ送信
            	mHandler.sendMessage(msg);

				//スレッドの利用変数を初期化
				time = now;
				count++;
			}
		}
	}
}
