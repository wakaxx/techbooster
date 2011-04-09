package org.jpn.techbooster.sample.ringerMode;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ringerMode extends Activity {
	/** Called when the activity is first created. */
	AudioManager am;
	Button btn_normalMode, btn_silentMode, btn_vibrateMode;
	TextView tv_ringerMode;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// AudioManager取得
		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

		// RingerMode表示用TextView
		tv_ringerMode = (TextView) findViewById(R.id.ringerMode);

		// 現在のRingerModeを表示
		showRingerMode();
		
		// ノーマルモード設定用ボタン
		btn_normalMode = (Button) findViewById(R.id.normalMode);
		btn_normalMode.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// setRingerModeメソッドでRingerModeをノーマルモードに設定
				am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

				// 現在のRingerModeを表示
				showRingerMode();
			}
		});

		// サイレントモード設定用ボタン
		btn_silentMode = (Button) findViewById(R.id.silentMode);
		btn_silentMode.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// setRingerModeメソッドでRingerModeをサイレントモードに設定
				am.setRingerMode(AudioManager.RINGER_MODE_SILENT);

				// 現在のRingerModeを表示
				showRingerMode();
			}
		});

		// バイブレートモード設定用ボタン
		btn_vibrateMode = (Button) findViewById(R.id.vibrateMode);
		btn_vibrateMode.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// setRingerModeメソッドでRingerModeをバイブレートモードに設定
				am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

				// 現在のRingerModeを表示
				showRingerMode();
			}
		});
	}
	
	// RingerMode表示メソッド
	void showRingerMode() {
		// getRingerModeメソッドで現在のRingerModeを取得
		switch (am.getRingerMode()) {
			// ノーマルモードの場合
			case AudioManager.RINGER_MODE_NORMAL:
				tv_ringerMode.setText("ノーマルモードに設定中.");
				break;
			// サイレントモードの場合
			case AudioManager.RINGER_MODE_SILENT:
				tv_ringerMode.setText("サイレントモードに設定中.");
				break;
			// バイブレートモードの場合
			case AudioManager.RINGER_MODE_VIBRATE:
				tv_ringerMode.setText("バイブレートモードに設定中.");
				break;
		}
	}
}