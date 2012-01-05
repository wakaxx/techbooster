package org.jpn.techbooster.sample.toggleBottunActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ToggleButtonActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ToggleButton tb = (ToggleButton) findViewById(R.id.ToggleButton01);

        tb.setTextOff("Toggle Off");
        tb.setTextOn("Toggle On");	//トグルボタンのメッセージ
        tb.setChecked(false);		//標準OFFへ変更

        //ToggleのCheckが変更したタイミングで呼び出し
        tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//トグルキーが変更された際に呼び出される
				Log.d("ToggleButton","call OnCheckdChangeListener");

			}
		});
    }
}