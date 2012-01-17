/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.viewFlipperActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class viewFlipperActivity extends Activity implements 
												OnGestureListener
												//OnClickListener
												{

	private ViewFlipper viewFlipper;
	private GestureDetector gestureDetector;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);

//        Button startButton = (Button) findViewById(R.id.startButton);
//        Button prevButton = (Button) findViewById(R.id.prevButton);
//        Button nextButton = (Button) findViewById(R.id.nextButton);
//        Button stopButton = (Button) findViewById(R.id.stopButton);
        
//        startButton.setOnClickListener(this);        
//        prevButton.setOnClickListener(this);
//        nextButton.setOnClickListener(this);
//        stopButton.setOnClickListener(this);
        gestureDetector = new GestureDetector(this, this);

//        viewFlipper.setAutoStart(true);		//自動でスライドショーを開始
//        viewFlipper.setFlipInterval(1000);	//更新間隔(ms単位)
    }

//	public void onClick(View v) {
//		// TODO 自動生成されたメソッド・スタブ
//
//		switch(v.getId()){
//		
//		case R.id.startButton:
//			viewFlipper.startFlipping();
//			break;
//
//		case R.id.prevButton:
//			viewFlipper.showPrevious();
//			break;
//
//		case R.id.nextButton:
//			viewFlipper.showNext();
//			break;
//			
//		case R.id.stopButton:
//			viewFlipper.stopFlipping();
//			break;
//			
//		default:
//				break;
//		}
//
//	}
    
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

	@Override
	public boolean onFling(MotionEvent e1 // TouchDown時のイベント
						,MotionEvent e2   // TouchDown後、指の移動毎に発生するイベント
						,float velocityX  // X方向の移動距離
						,float velocityY  // Y方向の移動距離
						) {
		// 絶対値の取得
		float dx = Math.abs(velocityX);
        float dy = Math.abs(velocityY);
        // 指の移動方向(縦横)および距離の判定
        if (dx > dy && dx > 300) {
        	// 指の移動方向(左右)の判定
            if (e1.getX() < e2.getX()) {
            	viewFlipper.showPrevious();
            } else {
            	viewFlipper.showNext();
            }
            return true;
        }
		return false;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}
}