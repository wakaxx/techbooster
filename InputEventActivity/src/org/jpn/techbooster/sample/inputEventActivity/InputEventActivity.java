/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.inputEventActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class InputEventActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		// InputDeviceの取得
		InputDevice inputDevice = event.getDevice();
		int deviceId = event.getDeviceId(); // デバイスIDを取得

		int source = event.getSource();

		Log.d("TouchEvent", "Input Device " + deviceId + " Source:" + source
				+ " X:" + event.getX() + ",Y:" + event.getY());

		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		// InputDeviceの取得
		InputDevice inputDevice = event.getDevice();
		int deviceId = event.getDeviceId(); // デバイスIDを取得

		int source = event.getSource();

		Log.d("KeyEvent", "Input Device " + deviceId + " Source:" + source
				+ " key:" + event.getKeyCode());

		return super.onKeyDown(keyCode, event);
	}
}