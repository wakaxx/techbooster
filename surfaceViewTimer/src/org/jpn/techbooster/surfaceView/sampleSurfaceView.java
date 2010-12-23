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
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class sampleSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{

	private Bitmap mImage;

	private SurfaceHolder mHolder;
	private Thread mLooper;

	//コンストラクタ
	public sampleSurfaceView(Context context) {
		super(context);

		getHolder().addCallback(this);
		mImage = BitmapFactory.decodeResource(getResources(), R.drawable.bakeneko);

	}

	public sampleSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//SurfaceView生成時に呼び出される
	public void surfaceCreated(SurfaceHolder holder) {

		//スレッドの生成
		mHolder = holder;
		mLooper = new Thread(this);
	}

	//SurfaceView変更時に呼び出される
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

		//スレッド処理を開始
		if(mLooper != null ){
			mHeight = height;
			mTime   = System.currentTimeMillis();
			mLooper.start();
		}

	}

	//SurfaceView破棄時に呼び出される
	public void surfaceDestroyed(SurfaceHolder holder) {
		//スレッドを削除
		mLooper = null;

	}

	private int mHeight;			//画面の高さ
	private int mPositionTop = 0;	//表示位置(TOP:Y座標)
	private int mPositionLeft = 0;	//表示位置(LEFT:X座標)
	private long mTime =0;			//一つ前の描画時刻
	private long mLapTime =0;		//画面上部から下部に到達するまでの時間

	//スレッドによるSurfaceView更新処理
	public void run() {

		while (mLooper != null) {

			//描画処理
			doDraw();


			//位置更新処理

			//処理落ちによるスローモーションをさけるため現在時刻を取得
			long delta = System.currentTimeMillis() - mTime;
			mTime      = System.currentTimeMillis();

			//次の描画位置
			int nextPosition = (int)( ( delta / 1000.0 ) * 200 ); //1秒間に200px動くとして

			//描画範囲の設定
			if(mPositionTop + nextPosition < mHeight  ){
				mPositionTop += nextPosition;
			}else{
				//画面の縦移動が終わるまでの時間計測(一定であることが期待値)
				Log.d("VIEW","mLapTime:" + (mTime - mLapTime) );
				mLapTime = mTime;

				//位置の初期化
				mPositionTop = 0;
			}
		}
	}

	//描画関数
	private void doDraw(){
		//Canvasの取得(マルチスレッド環境対応のためLock)
		Canvas canvas = mHolder.lockCanvas();

		Paint paint = new Paint();
		//描画処理(Lock中なのでなるべく早く)
		canvas.drawColor(Color.GRAY);
		canvas.drawBitmap(mImage, mPositionLeft, mPositionTop, paint);

		//LockしたCanvasを解放、ほかの描画処理スレッドがあればそちらに。
		mHolder.unlockCanvasAndPost(canvas);
	}
}