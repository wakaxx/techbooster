package org.jpn.techbooster.sample.seekbarActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final SeekBar sb0 = (SeekBar)findViewById(R.id.SeekBar00);
        final TextView tv0 = (TextView)findViewById(R.id.TextView00);

        // シークバーの初期値をTextViewに表示
        tv0.setText("設定値:"+sb0.getProgress());

        sb0.setOnSeekBarChangeListener(
                new OnSeekBarChangeListener() {
                    public void onProgressChanged(SeekBar seekBar,
                            int progress, boolean fromUser) {
                        // ツマミをドラッグしたときに呼ばれる
                    	tv0.setText("設定値:"+sb0.getProgress());
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // ツマミに触れたときに呼ばれる
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // ツマミを離したときに呼ばれる
                    }
                }
        );

        final SeekBar sb = (SeekBar)findViewById(R.id.SeekBar01);
        final TextView tv = (TextView)findViewById(R.id.TextView01);

        // シークバーの初期値をTextViewに表示
        tv.setText("設定値:"+sb.getProgress());

        sb.setOnSeekBarChangeListener(
                new OnSeekBarChangeListener() {
            		int oldValue;

                    public void onProgressChanged(SeekBar seekBar,
                            int progress, boolean fromUser) {
                        // ツマミをドラッグしたときに呼ばれる
                        tv.setText("設定値:"+sb.getProgress());
                        oldValue = sb.getProgress();
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // ツマミに触れたときに呼ばれる
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // ツマミを離したときに呼ばれる
                    	sb.setSecondaryProgress(oldValue);
                    }
                }
        );
    }
}