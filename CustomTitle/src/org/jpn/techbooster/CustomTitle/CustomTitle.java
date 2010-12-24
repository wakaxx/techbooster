package org.jpn.techbooster.CustomTitle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class CustomTitle extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// アイコン表示を有効にする
		requestWindowFeature(Window.FEATURE_LEFT_ICON);

		setContentView(R.layout.main);

		// アイコン表示
		getWindow().setFeatureDrawableResource(Window.FEATURE_LEFT_ICON,
				R.drawable.img);
		
		// アイコンを半透明に設定
		getWindow().setFeatureDrawableAlpha(Window.FEATURE_LEFT_ICON, 127);
	}
}
