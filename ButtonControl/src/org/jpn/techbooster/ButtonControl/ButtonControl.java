package org.jpn.techbooster.ButtonControl;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class ButtonControl extends Activity {
	TextView tv01;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tv01 = (TextView) findViewById(R.id.TextView01);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// キーコード表示
		tv01.setText("KeyCode:" + e.getKeyCode());

		// 検索ボタンが押されたとき
		if (e.getKeyCode() == KeyEvent.KEYCODE_SEARCH) {
			// ボタンが押し込まれたとき
			if (e.getAction() == KeyEvent.ACTION_DOWN) {
				tv01.setBackgroundColor(Color.RED);
			}
			// ボタンが離されたとき
			else if (e.getAction() == KeyEvent.ACTION_UP) {
				tv01.setBackgroundColor(Color.BLUE);
			}
			return true;
		}

		return super.dispatchKeyEvent(e);
	}
}
