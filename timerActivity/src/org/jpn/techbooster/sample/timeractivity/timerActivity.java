/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.timeractivity;

import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class timerActivity extends Activity implements OnClickListener{

   class MyTimerTask extends TimerTask{

    	@Override
    	public void run() {
    		// mHandlerを通じてUI Threadへ処理をキューイング
    		mHandler.post( new Runnable() {
    			public void run() {

    				//実行間隔分を加算処理
    				mLaptime +=  0.1d;

    				//計算にゆらぎがあるので小数点第1位で丸める
    				BigDecimal bi = new BigDecimal(mLaptime);
    				float outputValue = bi.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();

    				//現在のLapTime
    				mTextView.setText(Float.toString(outputValue));
    			}
    		});
    	}
    }

    MyTimerTask timerTask = null;		//onClickメソッドでインスタンス生成
	Timer   mTimer   = null;			//onClickメソッドでインスタンス生成
	Handler mHandler = new Handler();	//UI Threadへのpost用ハンドラ

	TextView mTextView;
	Button   mStartBtn, mStopBtn;
	float    mLaptime = 0.0f;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //IDの取得
        mTextView = (TextView) findViewById(R.id.LapTime);
        mStartBtn = (Button)   findViewById(R.id.StartBtn);
        mStopBtn  = (Button)   findViewById(R.id.StopBtn);

        mStartBtn.setOnClickListener(this);
        mStopBtn.setOnClickListener(this);
    }


	public void onClick(View v) {

		Button btn = (Button)v;

		switch( btn.getId() ){

		//スタートボタンが押されたとき
		case R.id.StartBtn:

			if(mTimer == null){

				//タイマーの初期化処理
				timerTask = new MyTimerTask();
				mLaptime = 0.0f;
		        mTimer = new Timer(true);
				mTimer.schedule( timerTask, 100, 100);
			}
			break;

		//ストップボタンが押されたとき
		case R.id.StopBtn:
			if(mTimer != null){
				mTimer.cancel();
				mTimer = null;
			}
			break;

		default:
			break;

		}
	}


}
