package org.jpn.techbooster.sample.serviceActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ServiceControllerActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button) findViewById(R.id.StartButton);
        btn.setOnClickListener(btnListener);//リスナの登録

        btn  = (Button) findViewById(R.id.StopButton);
        btn.setOnClickListener(btnListener);//リスナの登録

        btn  = (Button) findViewById(R.id.BindButton);
        btn.setOnClickListener(btnListener);

        btn  = (Button) findViewById(R.id.UnbindButton);
        btn.setOnClickListener(btnListener);
    }

    private OnClickListener btnListener = new OnClickListener() {
        public void onClick(View v) {

        	switch(v.getId()){

        	case R.id.StartButton://startServiceでサービス起動
                startService(new Intent(ServiceControllerActivity.this, MyService.class));
        		break;

        	case R.id.StopButton://stopServiceでサービス終了
                stopService(new Intent(ServiceControllerActivity.this, MyService.class));
        		break;

        	case R.id.BindButton://doBindService
        		doBindService();
        		break;

        	case R.id.UnbindButton://doUnbindService
        		doUnbindService();
        		break;

        	default:
        		break;
        	}

        }
    };

    //取得したServiceの保存
    private MyService mBoundService;
	private boolean mIsBound;

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {

        	// サービスとの接続確立時に呼び出される
            Toast.makeText(ServiceControllerActivity.this, "Activity:onServiceConnected",
                    Toast.LENGTH_SHORT).show();

        	// サービスにはIBinder経由で#getService()してダイレクトにアクセス可能
            mBoundService = ((MyService.MyServiceLocalBinder)service).getService();

            //必要であればmBoundServiceを使ってバインドしたサービスへの制御を行う
        }

        public void onServiceDisconnected(ComponentName className) {
            // サービスとの切断(異常系処理)
        	// プロセスのクラッシュなど意図しないサービスの切断が発生した場合に呼ばれる。
            mBoundService = null;
            Toast.makeText(ServiceControllerActivity.this, "Activity:onServiceDisconnected",
                    Toast.LENGTH_SHORT).show();
        }
    };


    void doBindService() {
    	//サービスとの接続を確立する。明示的にServiceを指定
    	//(特定のサービスを指定する必要がある。他のアプリケーションから知ることができない = ローカルサービス)
        bindService(new Intent(ServiceControllerActivity.this,
        		MyService.class), mConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
            // コネクションの解除
            unbindService(mConnection);
            mIsBound = false;
        }
    }
}