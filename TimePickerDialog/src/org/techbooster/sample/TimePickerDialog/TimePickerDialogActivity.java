package org.techbooster.sample.TimePickerDialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePickerDialogActivity extends Activity {

	TimePickerDialog dialog;
	TimePickerDialog.OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// 設定した時間をトーストで表示
			Toast.makeText(
					org.techbooster.sample.TimePickerDialog.TimePickerDialogActivity.this,
					"time set to " + Integer.toString(hourOfDay) + " : "
							+ Integer.toString(minute), Toast.LENGTH_LONG)
					.show();
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		Calendar calendar = Calendar.getInstance();
		// 現在の時間の取得
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		// 現在の分の取得
		int minute = calendar.get(Calendar.MINUTE);

		// ダイアログの生成、及び初期値の設定
		dialog = new TimePickerDialog(this, android.R.style.Theme_Black,
				onTimeSetListener, hourOfDay, minute, true);
		// ダイアログを表示する
		dialog.show();

	}
}
