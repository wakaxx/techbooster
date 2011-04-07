package org.jpn.techboostser.sample.scalegesturedetector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;

public class GestureDetectView extends View {
	private static final String TAG = "GestureDetectView";
	private ScaleGestureDetector _gestureDetector;
    
	private Drawable _image;
	private float _scaleFactor = 1.0f;
	
	private SimpleOnScaleGestureListener _simpleListener
		= new ScaleGestureDetector.SimpleOnScaleGestureListener() {
			@Override
			public boolean onScaleBegin(ScaleGestureDetector detector) {
				Log.d(TAG, "onScaleBegin : "+ detector.getScaleFactor());
				invalidate();
				return super.onScaleBegin(detector);
			}

			@Override
			public void onScaleEnd(ScaleGestureDetector detector) {
				Log.d(TAG, "onScaleEnd : "+ detector.getScaleFactor());
				_scaleFactor *= detector.getScaleFactor();
				invalidate();
				super.onScaleEnd(detector);
			}

			@Override
			public boolean onScale(ScaleGestureDetector detector) {
				Log.d(TAG, "onScale : "+ detector.getScaleFactor());
				_scaleFactor *= detector.getScaleFactor();
				invalidate();
				return true;
			};
		};
		
	public GestureDetectView(Context context) {
		super(context);
        _image = context.getResources().getDrawable(R.drawable.tb);
        _image.setBounds(0, 0, _image.getIntrinsicWidth(), _image.getIntrinsicHeight());
		_gestureDetector = new ScaleGestureDetector(context, _simpleListener);
	}
	
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.scale(_scaleFactor, _scaleFactor);
        _image.draw(canvas);
        canvas.restore();
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
    	_gestureDetector.onTouchEvent(ev);
        return true;
    }
    
}
