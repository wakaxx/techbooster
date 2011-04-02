package org.jpn.techbooster.sample.chronometer;



import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

public class chronometer extends Activity implements OnChronometerTickListener {
    Chronometer mChronometer;
    Button startButton, stopButton, clearButton;
    int time = 0;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // インスタンス作成
        mChronometer = (Chronometer) findViewById(R.id.chronometer);

        // ボタンリスナー登録
        startButton = (Button) findViewById(R.id.Start);
        startButton.setOnClickListener(mStartListener);
        
        stopButton = (Button) findViewById(R.id.Stop);
        stopButton.setOnClickListener(mStopListener);
        
        clearButton = (Button) findViewById(R.id.Clear);
        clearButton.setOnClickListener(mClearListener);
        
        // Chronometerイベントリスナーの登録
        mChronometer.setOnChronometerTickListener(this);
    }
    
    // Chronometerイベントリスナー
	@Override
	public void onChronometerTick(Chronometer chronometer) {
		// ログに経過時間を表示
		Log.i("chronometer", "time:"+time++);
	}

    View.OnClickListener mStartListener = new OnClickListener() {
        public void onClick(View v) {
// カウントアップスタート
mChronometer.start();
        }
    };

    View.OnClickListener mStopListener = new OnClickListener() {
        public void onClick(View v) {
// カウントアップストップ
mChronometer.stop();
        }
    };

    View.OnClickListener mClearListener = new OnClickListener() {
        public void onClick(View v) {
// カウントクリア
mChronometer.setBase(SystemClock.elapsedRealtime());
        }
    };
}