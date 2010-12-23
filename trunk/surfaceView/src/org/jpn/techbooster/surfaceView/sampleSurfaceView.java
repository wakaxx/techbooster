/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.surfaceView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class sampleSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

	private Bitmap mImage;

	//コンストラクタ
	public sampleSurfaceView(Context context) {
		super(context);

		getHolder().addCallback(this);
		mImage = BitmapFactory.decodeResource(getResources(), R.drawable.bakeneko);

	}

	public sampleSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	//SurfaceView生成時に呼び出される
	public void surfaceCreated(SurfaceHolder holder) {

		//初期描画(生成タイミングで描画する必要があるもの)

		//Canvasの取得(マルチスレッド環境対応のためLock)
		Canvas canvas = holder.lockCanvas();
		Paint paint = new Paint();
		paint.setTextSize(24);
		paint.setColor(Color.WHITE);

		//描画処理(Lock中なのでなるべく早く)
		canvas.drawBitmap(mImage, 0, 0, paint);
		canvas.drawText("TechBooster",0,200,paint);


		//LockしたCanvasを解放、ほかの描画処理スレッドがあればそちらに。
		holder.unlockCanvasAndPost(canvas);


	}

	//SurfaceView変更時に呼び出される
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

	}

	//SurfaceView破棄時に呼び出される
	public void surfaceDestroyed(SurfaceHolder holder) {

	}

}