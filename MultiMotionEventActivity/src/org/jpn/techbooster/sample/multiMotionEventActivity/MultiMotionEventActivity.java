/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.multiMotionEventActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MultiMotionEventActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	Log.d("TouchEvent", "X:" + event.getX() + ",Y:" + event.getY());


    	int historySize = event.getHistorySize();	//ACTION_MOVEイベントの数
    	int pointerCount = event.getPointerCount();

		//イベントの発生時刻
		Log.d("TouchEvent", "event time: "+ event.getEventTime());

		//ポインタIDの取得、ポインタ座標
		for (int p = 0; p < pointerCount; p++) {
			Log.d("TouchEvent", "Pointer ID :"+ event.getPointerId(p) +
					" X " + event.getX(p) + " , " +
					 "Y " + event.getY(p) + " , " );
		}

		//イベント履歴
    	for (int h = 0; h < historySize; h++) {
    		Log.d("TouchEventHist", "event time: "+ event.getHistoricalEventTime(h));
    		for (int p = 0; p < pointerCount; p++) {
    			Log.d("TouchEventHist", "Pointer ID :"+ event.getPointerId(p) +
    					" X " + event.getHistoricalX(p, h) + " , " +
    					 "Y " + event.getHistoricalY(p, h) + " , " );
    		}
    	}

    	return true;
    }
}