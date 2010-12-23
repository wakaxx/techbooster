/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.datepickerdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;

public class DatePickerDialogActivity extends Activity {

	DatePickerDialog datePickerDialog;

	//日付設定時のリスナ登録
	DatePickerDialog.OnDateSetListener DateSetListener = new DatePickerDialog.OnDateSetListener(){
		public void onDateSet(android.widget.DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

			//ログ出力
			Log.d("DatePicker","year:" +year + " monthOfYear:" + monthOfYear + " dayOfMonth:" + dayOfMonth);
		}
	};


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //日付情報の初期設定
        Calendar calendar 	= Calendar.getInstance();
        int year 			= calendar.get(Calendar.YEAR);
        int monthOfYear 	= calendar.get(Calendar.MONTH);
        int dayOfMonth 		= calendar.get(Calendar.DAY_OF_MONTH);

        //日付設定ダイアログの作成
        //datePickerDialog = new DatePickerDialog(this, DateSetListener, year, monthOfYear, dayOfMonth);
        datePickerDialog = new DatePickerDialog(this,android.R.style.Theme_Light, DateSetListener, year, monthOfYear, dayOfMonth);

        //日付設定ダイアログの表示
        datePickerDialog.show();

    }
}