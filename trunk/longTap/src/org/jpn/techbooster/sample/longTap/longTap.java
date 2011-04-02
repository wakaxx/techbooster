package org.jpn.techbooster.sample.longTap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class longTap extends Activity implements
		GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
	// GestureDetectorインスタンス変数
	GestureDetector gestureDetector;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// GestureDetectorインスタンス作成
		gestureDetector = new GestureDetector(this, this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// gestureDetector#onTouchEventメソッドでタッチイベントの判別・振り分けを行う
		gestureDetector.onTouchEvent(ev);

		return false;
	}

	public boolean onDown(MotionEvent e) {
		Toast.makeText(this, "called onDown()", Toast.LENGTH_LONG).show();
		return false;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Toast.makeText(this, "called onFling()", Toast.LENGTH_LONG).show();
		return false;
	}

	public void onLongPress(MotionEvent e) {
		Toast.makeText(this, "called onLongPress()", Toast.LENGTH_LONG).show();

	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Toast.makeText(this, "called onScroll()", Toast.LENGTH_LONG).show();
		return false;
	}

	public void onShowPress(MotionEvent e) {
		Toast.makeText(this, "called onShowPress()", Toast.LENGTH_LONG).show();

	}

	public boolean onSingleTapUp(MotionEvent e) {
		Toast.makeText(this, "called onSingleTapUp()", Toast.LENGTH_LONG)
				.show();
		Log.i("longTap", "called onSingleTapUp()");
		return false;
	}

	public boolean onDoubleTap(MotionEvent e) {
		Toast.makeText(this, "called onDoubleTap()", Toast.LENGTH_LONG).show();
		Log.i("longTap", "called onDoubleTap()");
		return false;
	}

	public boolean onDoubleTapEvent(MotionEvent e) {
		Toast.makeText(this, "called onDoubleTapEvent()", Toast.LENGTH_LONG)
				.show();
		return false;
	}

	public boolean onSingleTapConfirmed(MotionEvent e) {
		Toast.makeText(this, "called onSingleTapConfirmed()", Toast.LENGTH_LONG)
				.show();
		Log.i("longTap", "called onSingleTapConfirmed()");
		return false;
	}
}