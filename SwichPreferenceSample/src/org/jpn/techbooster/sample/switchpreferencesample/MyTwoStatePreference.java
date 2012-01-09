package org.jpn.techbooster.sample.switchpreferencesample;

import android.content.Context;
import android.preference.TwoStatePreference;
import android.util.AttributeSet;

public class MyTwoStatePreference extends TwoStatePreference {

	// constructor
	public MyTwoStatePreference(Context context) {
		this(context,null);
	}

	public MyTwoStatePreference(Context context, AttributeSet attrs){
		// SwitchPreference を指定
		// android.R.attr.checkBoxPreferenceStyle でcheckBoxPreferenceにできる
		this(context,attrs,android.R.attr.switchPreferenceStyle);
	}
	
	public MyTwoStatePreference(Context context, AttributeSet attrs, int defStyle){
		super(context,attrs,defStyle);
	}

	@Override
	public boolean getDisableDependentsState() {
		
		
		return super.getDisableDependentsState();
	}

	@Override
	public CharSequence getSummaryOff() {

		return super.getSummaryOff();
	}

	@Override
	public CharSequence getSummaryOn() {

		return super.getSummaryOn();
	}

	@Override
	public boolean isChecked() {

		return super.isChecked();
	}

	@Override
	public void setChecked(boolean checked) {

		super.setChecked(checked);
	}

	@Override
	public void setDisableDependentsState(boolean disableDependentsState) {

		super.setDisableDependentsState(disableDependentsState);
	}

	@Override
	public void setSummaryOff(CharSequence summary) {

		super.setSummaryOff(summary);
	}

	@Override
	public void setSummaryOff(int summaryResId) {

		super.setSummaryOff(summaryResId);
	}

	@Override
	public void setSummaryOn(CharSequence summary) {

		super.setSummaryOn(summary);
	}

	@Override
	public void setSummaryOn(int summaryResId) {

		super.setSummaryOn(summaryResId);
	}

	@Override
	public boolean shouldDisableDependents() {

		return super.shouldDisableDependents();
	}

	
	
	
	
	
}
