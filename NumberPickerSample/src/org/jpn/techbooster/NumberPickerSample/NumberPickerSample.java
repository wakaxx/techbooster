package org.jpn.techbooster.NumberPickerSample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.NumberPicker.OnValueChangeListener;

public class NumberPickerSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        NumberPicker np = (NumberPicker)findViewById(R.id.numberPicker1);

        //最大値設定
        np.setMaxValue(1000);
        //最小値設定
        np.setMinValue(0);

        //値が更新された時に発生するイベント
        np.setOnValueChangedListener(new OnValueChangeListener() {
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				updateText(newVal);
			}
		});
    }

    private void updateText(int value){
    	TextView tv = (TextView)findViewById(R.id.textview01);
    	tv.setText(String.valueOf(value));
    }
}