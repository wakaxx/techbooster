package org.jpn.techbooster.SeekBarSample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekBarSample extends Activity {
    SeekBar seekBar;
    TextView tv1;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        seekBar = (SeekBar)findViewById(R.id.SeekBar01);
        tv1 = (TextView)findViewById(R.id.TextView01);
        
        // シークバーの初期値をTextViewに表示
        tv1.setText("Current Value:"+seekBar.getProgress());
        
        seekBar.setOnSeekBarChangeListener(
        		new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						// ツマミをドラッグしたときに呼ばれる
						tv1.setText("Current Value:"+progress);
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
						// ツマミに触れたときに呼ばれる
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
						// ツマミを離したときに呼ばれる
					}
        		}
        );
    }
}