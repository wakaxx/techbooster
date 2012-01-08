package org.techbooster.sample.datepickerdialog;

import java.util.Calendar;

import jp.oriver.volunteer.sample.R;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;

public class DatepickersampleActivity extends Activity implements OnDateChangedListener{

	DatePickerDialog datePickerDialog;

	// 日付設定時のリスナ作成
	DatePickerDialog.OnDateSetListener DateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(android.widget.DatePicker datePicker, int year,
				int monthOfYear, int dayOfMonth) {
			// トーストとログ出力
			Toast.makeText(
					org.techbooster.sample.datepickerdialog.DatepickersampleActivity.this,
					"year:" + year + " monthOfYear:" + monthOfYear
					+ " dayOfMonth:" + dayOfMonth, Toast.LENGTH_LONG)
					.show();
			Log.d("DatePicker", "year:" + year + " monthOfYear:" + monthOfYear
					+ " dayOfMonth:" + dayOfMonth);
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		// 日付情報の初期設定
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR); // 年
		int monthOfYear = calendar.get(Calendar.MONTH); // 月
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // 日

		// 日付設定ダイアログの作成・リスナの登録
		datePickerDialog = new DatePickerDialog(this,
				android.R.style.Theme_Black_NoTitleBar, DateSetListener, year,
				monthOfYear, dayOfMonth);

		// 日付設定ダイアログの表示
		datePickerDialog.show();

		//追記（DatePickerを取得し、onDateChangedのリスナ登録をする）
		//DatePicker datePicker = datePickerDialog.getDatePicker();
		//datePicker.init(year, monthOfYear, dayOfMonth, this);
	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		Log.d("DatePicker", "onDateChanged year:" + year + " monthOfYear:" + monthOfYear
				+ " dayOfMonth:" + dayOfMonth);
	}

}