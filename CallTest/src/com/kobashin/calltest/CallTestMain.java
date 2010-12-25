package com.kobashin.calltest;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CallTestMain extends Activity {
	private TelephonyManager mTelephonyManager;
	private LinearLayout lLayout;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Viewの準備もろもろ */
        lLayout = (LinearLayout)findViewById(R.id.CallTestMain_Linear);
		mTelephonyManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
		mTelephonyManager.listen(mPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        
    }
    
    PhoneStateListener mPhoneStateListener = new PhoneStateListener() {
    	@Override
    	public void onCallStateChanged(int state, String number) {
    		phoneCallEvent(state, number);
        }
    };
    
    private void phoneCallEvent(int state, String number){
		switch(state) {
	        case TelephonyManager.CALL_STATE_RINGING:
	        	/* TextViewを追加する */
	        	TextView tv_ring = new TextView(this);
	        	tv_ring.setText("着信   "+number);
	        	lLayout.addView(tv_ring);
	        	
	        	/* Toastの表示 */
	        	Toast.makeText(this, "Ringing　なう！", Toast.LENGTH_SHORT).show();
	        	break;
	
	        case TelephonyManager.CALL_STATE_OFFHOOK:
	        	TextView tv_offhook = new TextView(this);
	        	tv_offhook.setText("通話中");
	        	lLayout.addView(tv_offhook);
	        	
	        	/* Toastの表示 */
	        	Toast.makeText(this, "通話中　なう。", Toast.LENGTH_SHORT).show();
	            break;
	
	        case TelephonyManager.CALL_STATE_IDLE:
	        	TextView tv_idle = new TextView(this);
	        	tv_idle.setText("待ち受け状態");
	        	lLayout.addView(tv_idle);

	        	/* Toastの表示 */
	        	Toast.makeText(this, "まちうけ画面です。", Toast.LENGTH_SHORT).show();
	        	break;
		};
    }
}