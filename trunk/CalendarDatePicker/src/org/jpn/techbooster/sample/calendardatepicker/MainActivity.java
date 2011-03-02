package org.jpn.techbooster.sample.calendardatepicker;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {
	DatePicker _datePicker;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        _datePicker = (DatePicker)findViewById(R.id.datePicker);
        ToggleButton buttonCalender = (ToggleButton)findViewById(R.id.buttonCalnedar);
        ToggleButton buttonSpinners = (ToggleButton)findViewById(R.id.buttonSpinners);
        buttonCalender.setOnClickListener(this);
        buttonSpinners.setOnClickListener(this);
        
        // 2011/1/1 〜 2011/12/31に制限する(デフォルトは 1900/1/1 〜 2200/12/31)
        Date minDate = new Date(111, 0, 1);
        Date maxDate = new Date(111, 11, 31);
        _datePicker.setMinDate(minDate.getTime());
        _datePicker.setMaxDate(maxDate.getTime());
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonCalnedar:
			_datePicker.setCalendarViewShown(((ToggleButton)v).isChecked());
			break;
		case R.id.buttonSpinners:
			_datePicker.setSpinnersShown(((ToggleButton)v).isChecked());
			break;
		default:
			break;
		}
	}
}