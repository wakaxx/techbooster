package org.jpn.techbooster.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

public class uiModeManager extends Activity {
	Button btn_carMode, btn_nightMode;
	boolean carMode = false;
	boolean nightMode = false;
	UiModeManager umm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// UiModeManagerのインスタンスを取得
		umm = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);

		// CarModeのスイッチ用ボタン
		btn_carMode = (Button) findViewById(R.id.btn_carMode);
		btn_carMode.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				// 現在、Car Modeで動作していない場合
				if (umm.getCurrentModeType() == Configuration.UI_MODE_TYPE_NORMAL) {
					// CarModeをenableにする
					umm.enableCarMode(0);
					Toast.makeText(getApplicationContext(), "enable CarMode", Toast.LENGTH_SHORT).show();
					
				// 現在、Car Modeで動作している場合
				} else if (umm.getCurrentModeType() == Configuration.UI_MODE_TYPE_CAR) {
					// CarModeをdisableにする
					umm.disableCarMode(0);
					Toast.makeText(getApplicationContext(), "disable CarMode", Toast.LENGTH_SHORT).show();
				}
				
			}
		});

		// NightModeのスイッチ用ボタン
		btn_nightMode = (Button) findViewById(R.id.btn_nightMode);
		btn_nightMode.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				// 現在、Night Modeで動作している場合
				if (umm.getNightMode() == UiModeManager.MODE_NIGHT_YES) {
					// NightModeを無効にする
					umm.setNightMode(UiModeManager.MODE_NIGHT_NO);
					Toast.makeText(getApplicationContext(), "disable NightMode", Toast.LENGTH_SHORT).show();
					
				// 現在、Night Modeで動作していない場合
				} else if (umm.getNightMode() == UiModeManager.MODE_NIGHT_NO) {
					// NightModeを有効にする
					umm.setNightMode(UiModeManager.MODE_NIGHT_YES);
					Toast.makeText(getApplicationContext(), "enable NightMode",	Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}
}
