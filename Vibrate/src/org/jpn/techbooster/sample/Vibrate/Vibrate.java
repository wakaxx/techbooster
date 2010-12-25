package org.jpn.techbooster.sample.Vibrate;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Vibrate extends Activity {
	/** Called when the activity is first created. */
	Button button;
	ClickListener listener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button = (Button) findViewById(R.id.Button01);
		listener = new ClickListener();
		button.setOnClickListener(listener);
	}

	class ClickListener implements OnClickListener {
		public void onClick(View v) {
			long pattern[] = { 1000, 500, 3000, 500, 1000, 500 }; // 1000ミリ秒OFF→500ミリ秒ON→3000ミリ秒OFF→500ミリ秒ON→1000ミリ秒OFF→500ミリ秒ON
			((Vibrator) getSystemService(VIBRATOR_SERVICE))
					.vibrate(pattern, -1); // 定義したパターン・リピートなしでバイブレーション開始
		}
	};
}
