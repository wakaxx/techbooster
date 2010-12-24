package org.jpn.techbooster.BackLightSample;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class BackLightSample extends Activity {
	SeekBar seekBar;
	TextView tv1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		seekBar = (SeekBar) findViewById(R.id.SeekBar01);
		tv1 = (TextView) findViewById(R.id.TextView01); //

		// シークバーの初期値をTextViewに表示
		tv1.setText("Brightness:");

		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				float value = progress / 100f; // プログレスバーの値を輝度設定値に変換

				if (value > 0f) { // 輝度の値は1.00以上でないと設定しない
					WindowManager.LayoutParams lp = getWindow().getAttributes();
					lp.screenBrightness = value; // プログレスバーの値を設定
					getWindow().setAttributes(lp);
	
					tv1.setText("Brightness:" + value + "%"); // 設定輝度を表示
				}
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// ツマミに触れたときに呼ばれる
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// ツマミを離したときに呼ばれる
			}
		});
	}
}
