/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.touchevent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class touchEventActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		Log.d("TouchEvent", "X:" + event.getX() + ",Y:" + event.getY());

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Log.d("TouchEvent", "getAction()" + "ACTION_DOWN");
			break;
		case MotionEvent.ACTION_UP:
			Log.d("TouchEvent", "getAction()" + "ACTION_UP");
			break;
		case MotionEvent.ACTION_MOVE:
			Log.d("TouchEvent", "getAction()" + "ACTION_MOVE");
			break;
		case MotionEvent.ACTION_CANCEL:
			Log.d("TouchEvent", "getAction()" + "ACTION_CANCEL");
			break;
		}

		return true;
	}
}