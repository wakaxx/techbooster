package org.jpn.techbooster.sample.timepickersample;

import org.jpn.techbooster.sample.timepickersample.CustomTimePicker.OnTimeChangedListener;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainSample extends Activity implements OnClickListener, OnTimeChangedListener {
	static final int HOUR_MODE = 1;
	static final int MINUTE_MODE = 2;
	
	CustomTimePicker hourPicker;
	CustomTimePicker minutePicker;
	
	TimePicker timePicker;
	int myhour = 0;
	int myminute = 0;
	TextView htv,mtv;
	Button hincrement, mincrement;
	Button hdecrement, mdecrement;
	Picker hPicker;
	Picker mPicker;
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Buttonの設定
		((Button)findViewById(R.id.button1)).setOnClickListener(this);
		
		LinearLayout ll = (LinearLayout)findViewById(R.id.parentLayout);
		
		// CostomTimePickerをLayoutに差し込む
		hourPicker = new CustomTimePicker(this);
		hourPicker.setRange(0, 12);
		hourPicker.setOnChangeListener(this);
		ll.addView(hourPicker);
		
		minutePicker = new CustomTimePicker(this);
		minutePicker.setRange(0, 59);
		minutePicker.setOnChangeListener(this);
		ll.addView(minutePicker);
		
		
		
		
/*		
		hPicker = new Picker(findViewById(R.id.hour),HOUR_MODE);
		hincrement = hPicker.getIncrementButton();
		hdecrement = hPicker.getDecrementButton();
		
		mPicker = new Picker(findViewById(R.id.minute),MINUTE_MODE);
		mincrement = mPicker.getIncrementButton();
		mdecrement = mPicker.getDecrementButton();

		hincrement.setOnClickListener(this);
		hdecrement.setOnClickListener(this);
		mincrement.setOnClickListener(this);
		mdecrement.setOnClickListener(this);
*/
	}

	
	@Override
	public void onClick(View v) {
		Log.v("","--------------- get hour = "+hourPicker.getVal());
		Log.v("","--------------- get minute = "+minutePicker.getVal());

	}

	@Override
	public void onTimeChanged(CustomTimePicker costumTimePicker, int val) {
		Log.v("","--------------- onChange ="+val);
	}

	
	private class Picker{
		
		private int MaxData;
		Button increment;
		Button decrement;
		EditText ev;
		View parentView;
		
		Picker(View v,int mode){
			parentView = v;
			increment = (Button)v.findViewById(R.id.increment);
			decrement = (Button) v.findViewById(R.id.decrement);
			ev = (EditText)v.findViewById(R.id.timepicker_input);
			ev.setFilters(new InputFilter[] {new InputFilter.LengthFilter(2)});
			if(mode == HOUR_MODE){
				MaxData = 23;
			}else if(mode == MINUTE_MODE){
				MaxData = 59;
			}
		}
		
		public EditText getNumber(){
			return ev;
		}
		public Button getIncrementButton(){
			return increment;
		}
		public Button getDecrementButton(){
			return decrement;
		}
		
	}


	
}