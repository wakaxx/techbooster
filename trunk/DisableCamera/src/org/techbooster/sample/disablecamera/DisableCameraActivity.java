package org.techbooster.sample.disablecamera;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DisableCameraActivity extends Activity {
	
	DevicePolicyManager mDPM;
	ComponentName mLockReciever;
	boolean mAdminActive;
	
    protected DisableCameraActivity mActivity;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // DevicePolicyManagerインスタンス生成
        mDPM = (DevicePolicyManager)getSystemService(this.DEVICE_POLICY_SERVICE);
        mLockReciever = new ComponentName(this, LockReciever.class);
        
        // デバイス管理権限を有効にする画面を呼び出す
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
        		mLockReciever);
        startActivityForResult(intent, 1);
        
        // デバイスの管理権限の状態(Enable/Disable)を取得
        mAdminActive = mDPM.isAdminActive(mLockReciever);
        
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if (mAdminActive) {
					mDPM.setCameraDisabled(mLockReciever, true);
				}
			}
        });
        
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if (mAdminActive) {
					mDPM.setCameraDisabled(mLockReciever, false);
				}
			}
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == Activity.RESULT_OK) {
                    Log.i("DeviceAdminSample", "Administration enabled!");
                } else {
                    Log.i("DeviceAdminSample", "Administration enable FAILED!");
                }
                return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

//	private boolean isActiveAdmin() {
//		int hoge = 1;
//		hoge++;
//        return mDPM.isAdminActive(mDisableCameraActivity);
//    }

}