package org.jpn.techbooster.sample.keyLongPress;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

public class keyLongPress extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	// onKeyLongPressメソッドをオーバーライドする
	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		Log.i("onKeyLongPress", "keyCode:" + keyCode);
		
		// バックキーの長押しに対する処理
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			Toast.makeText(this, "バックキーが長押しされました！", Toast.LENGTH_SHORT).show();
			return true;
			// 検索キーの長押しに対する処理
		} else if (event.getKeyCode() == KeyEvent.KEYCODE_SEARCH) {
			Toast.makeText(this, "検索キーが長押しされました！", Toast.LENGTH_SHORT).show();
			return true;
		}

		// バックキー、検索キー以外の長押しはスルー
		return super.onKeyLongPress(keyCode, event);
	}
}
