/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jpn.techbooster.sample.timepickersample;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CustomTimePicker extends LinearLayout implements OnClickListener {

	private OnTimeChangedListener mOnTimeChangedListener;
	private EditText ev;
	private String[] mDisplayedValues;
	private final InputFilter mNumberInputFilter;

	private int mEnd;
	private int mStart;

	public interface OnTimeChangedListener {

		/**
		 * @param costumTimePicker
		 *            The view associated with this listener.
		 * @param hour
		 *            The current val.
		 */
		void onTimeChanged(CustomTimePicker costumTimePicker, int val);
	}

	public CustomTimePicker(Context context) {
		this(context, null);
	}

	public CustomTimePicker(Context context, AttributeSet attrs) {
		super(context, attrs);

		// Layoutファイルのinflate
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View parent = inflater.inflate(R.layout.ctime_picker, this, true);

		// +-のButtonのlistener設定
		((Button) parent.findViewById(R.id.increment)).setOnClickListener(this);
		((Button) parent.findViewById(R.id.decrement)).setOnClickListener(this);

		// 数値表示のTextViewへFilterの設定
		// androidのソースコードから移植したFilterを設定する
		ev = (EditText) parent.findViewById(R.id.timepicker_input);
		InputFilter inputFilter = new NumberPickerInputFilter();
		mNumberInputFilter = new NumberRangeKeyListener();
		
		ev.setFilters(new InputFilter[] {inputFilter});

		
	}

	/**
	 * EditTextに表示中の数値から
	 * increment/decrementを行う
	 */
	@Override
	public void onClick(View v) {
		// 表示値の取得
		int current;
		try{
			current = Integer.valueOf(ev.getText().toString());
		}catch(NumberFormatException ne){
			current = mStart;
		}
		
		if(v.getId() == R.id.increment){
			if(current < mEnd){
				current++;
				ev.setText(Integer.toString(current));
			}
		}
		else if(v.getId() == R.id.decrement){
			if(current > mStart){
				current--;
				ev.setText(Integer.toString(current));
			}
		}
		
		// Listener呼び出し
		changeVal(current);
	}

	/**
	 * 表示中の値を返す
	 * @return 表示中の値を返す
	 */
	public int getVal(){
		if(ev == null){
			return -1;
		}

		return  Integer.valueOf(ev.getText().toString()); 
	}
	
	
	
	/**
	 * Listenerを呼び出す
	 * @param cur
	 */
	private void changeVal(int cur){
		mOnTimeChangedListener.onTimeChanged(this, cur);
	}

	private class NumberPickerInputFilter implements InputFilter {
		public CharSequence filter(CharSequence source, int start, int end,
				Spanned dest, int dstart, int dend) {
			if (mDisplayedValues == null) {
				return mNumberInputFilter.filter(source, start, end, dest,
						dstart, dend);
			}
			CharSequence filtered = String.valueOf(source.subSequence(start,
					end));
			String result = String.valueOf(dest.subSequence(0, dstart))
					+ filtered + dest.subSequence(dend, dest.length());
			String str = String.valueOf(result).toLowerCase();
			for (String val : mDisplayedValues) {
				val = val.toLowerCase();
				if (val.startsWith(str)) {
					return filtered;
				}
			}
			return "";
		}
	}

	private static final char[] DIGIT_CHARACTERS = new char[] { '0', '1', '2',
			'3', '4', '5', '6', '7', '8', '9' };

	private class NumberRangeKeyListener extends NumberKeyListener {

		// XXX This doesn't allow for range limits when controlled by a
		// soft input method!
		public int getInputType() {
			return InputType.TYPE_CLASS_NUMBER;
		}

		@Override
		protected char[] getAcceptedChars() {
			return DIGIT_CHARACTERS;
		}

		@Override
		public CharSequence filter(CharSequence source, int start, int end,
				Spanned dest, int dstart, int dend) {

			CharSequence filtered = super.filter(source, start, end, dest,
					dstart, dend);
			if (filtered == null) {
				filtered = source.subSequence(start, end);
			}

			String result = String.valueOf(dest.subSequence(0, dstart))
					+ filtered + dest.subSequence(dend, dest.length());

			if ("".equals(result)) {
				return result;
			}
			int val = getSelectedPos(result);

			/*
			 * Ensure the user can't type in a value greater than the max
			 * allowed. We have to allow less than min as the user might want to
			 * delete some numbers and then type a new number.
			 */
			if (val > mEnd) {
				return "";
			} else {
				return filtered;
			}
		}
	}

	private int getSelectedPos(String str) {
		if (mDisplayedValues == null) {
			try {
				return Integer.parseInt(str);
			} catch (NumberFormatException e) {
				/* Ignore as if it's not a number we don't care */
			}
		} else {
			for (int i = 0; i < mDisplayedValues.length; i++) {
				/* Don't force the user to type in jan when ja will do */
				str = str.toLowerCase();
				if (mDisplayedValues[i].toLowerCase().startsWith(str)) {
					return mStart + i;
				}
			}

			/*
			 * The user might have typed in a number into the month field i.e.
			 * 10 instead of OCT so support that too.
			 */
			try {
				return Integer.parseInt(str);
			} catch (NumberFormatException e) {

				/* Ignore as if it's not a number we don't care */
			}
		}
		return mStart;
	}
	
	public void setRange(int start, int end) {
        mStart = start;
        mEnd = end;
    }

	public void setOnChangeListener(OnTimeChangedListener listener) {
		mOnTimeChangedListener = listener;
    }

}