/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.timepickerdialog;

import java.util.Calendar;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TimePicker;

public class timePickerDialogActivity extends Activity {

	TimePickerDialog timePickerDialog;

	//時刻設定時のリスナ登録
	TimePickerDialog.OnTimeSetListener TimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

			//ログ出力
			Log.d("TimePicker","hourOfDay:" + hourOfDay + " minute:" + minute);
		}
	};


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //日付情報の初期設定
        Calendar calendar 	= Calendar.getInstance();

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute    = calendar.get(Calendar.MINUTE);


        //時刻設定ダイアログの作成
        timePickerDialog = new TimePickerDialog(this, TimeSetListener, hourOfDay, minute, false);

        //時刻設定ダイアログの表示
        timePickerDialog.show();
    }
}