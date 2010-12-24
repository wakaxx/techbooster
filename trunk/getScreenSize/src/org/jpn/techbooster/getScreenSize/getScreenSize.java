package org.jpn.techbooster.getScreenSize;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.TextView;

public class getScreenSize extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// WindowManagerのハンドルを取得
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

		// デフォルトのディスプレイオブジェクトを取得
		Display disp = wm.getDefaultDisplay();

		// width、heightを取得
		int width = disp.getWidth();
		int height = disp.getHeight();

		// width、heightを表示
		TextView tv = (TextView) findViewById(R.id.TextView);
		tv.setText("width:" + width + "/" + "height:" + height);
	}
}
