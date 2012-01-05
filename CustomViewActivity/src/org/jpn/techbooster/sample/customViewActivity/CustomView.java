package org.jpn.techbooster.sample.customViewActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


class CustomView extends View
{


	public CustomView(Context context) {
		super(context);
	}

	public CustomView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
     * XMLより呼び出す際のコンストラクタ
     * @param context, attrs
     */
    public CustomView(Context context, AttributeSet attrs)
    {
    	super(context, attrs);
    	setFocusable(true);
    	initPaint();
    }



	//描画用ビットマップ、キャンパス、パス、ペイント設定
    private Bitmap  mBitmap;
    private Canvas  mCanvas;
    private Path    mPath;
    private Paint   mPaint;

    /*
     * 描画用Paintの初期化
     * */
    private void initPaint(){
        mPath = new Path();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(0xFFFF0000);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(12);
    }

    /**
     * 画面サイズ変更時の通知
     * @param w, h, oldw, oldh
     */
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        Log.v("View", "onSizeChanged Width:" + w + ",Height:" + h );

        //キャンバス作成
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    /*
     * 描画関数
     * */
    @Override
    protected void onDraw(Canvas canvas) {

    	canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    	canvas.drawPath(mPath, mPaint);

    }


    private float mX, mY;
    private static final float TOUCH_TOLERANCE = 4;

    private void touch_start(float x, float y) {
        Log.v("View", "touch_start");
        mPath.reset();
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touch_move(float x, float y) {
        Log.d("View", "touch_move");

        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);

        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
            mX = x;
            mY = y;
        }
    }
    private void touch_up() {
        Log.v("View", "touch_up");

        mPath.lineTo(mX, mY);
        mCanvas.drawPath(mPath, mPaint);
        mPath.reset();
    }

    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touch_start(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touch_move(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touch_up();
                invalidate();
                break;
        }
        return true;
    }



}
