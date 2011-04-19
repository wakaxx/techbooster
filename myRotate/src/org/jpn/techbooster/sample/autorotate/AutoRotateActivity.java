package org.jpn.techbooster.sample.autorotate;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AutoRotateActivity extends Activity implements SensorEventListener{

    private static final int MATRIX_SIZE = 16;

	/* センサーマネージャ */
	private SensorManager mSensorManager;
	private boolean mIsMagSensor;
	private boolean mIsAccSensor;

	/* 回転行列 */
    float[]  inR = new float[MATRIX_SIZE];
    float[] outR = new float[MATRIX_SIZE];
    float[]    I = new float[MATRIX_SIZE];

    /* センサーの値 */
    float[] orientationValues   = new float[3];
    float[] magneticValues      = new float[3];
    float[] accelerometerValues = new float[3];

    //描画するView
    ContentView view;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    //今回は内部クラスを表示
	    view = new ContentView(this);
	    setContentView(view);

	    /* センサーマネージャを取得する */
	    mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

	}

	//* onResume */
	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();


		// センサの取得
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

	    // センサマネージャへリスナーを登録(implements SensorEventListenerにより、thisで登録する)
        for (Sensor sensor : sensors) {

        	if( sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
        		mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        		mIsMagSensor = true;
        	}

        	if( sensor.getType() == Sensor.TYPE_ACCELEROMETER){
        		mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        		mIsAccSensor = true;
        	}

	        /*
	         * int	SENSOR_DELAY_FASTEST	最高速でのセンサ読み出し
	         * int 	SENSOR_DELAY_GAME		  高速ゲーム向け
	         * int 	SENSOR_DELAY_NORMAL 	  通常モード
	         * int 	SENSOR_DELAY_UI 		  低速。ユーザインターフェイス向け
	         */
        }
	}

	//* onPause */
	@Override
	protected void onPause() {
		// TODO 自動生成されたメソッド・スタブ
		super.onPause();

		//センサーマネージャのリスナ登録破棄
	    if (mIsMagSensor || mIsAccSensor) {
	        mSensorManager.unregisterListener(this);
	        mIsMagSensor = false;
	        mIsAccSensor = false;
	    }
	}

	// SensorEventListenerなので追加。ただし、使わないのでStub
	// センサーの精度が変更されたときに呼び出される。
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 自動生成されたメソッド・スタブ
	}


	// SensorEventListenerなので追加。こちらは使います。
	// センサーの値が変更されたとき(TYPE_ORIENTATIONなので傾きが変わったとき。)
	// 通知タイミングはSENSOR_DELAY_UIで、UIに最適なAndroid規定値
	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ

        if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) return;


		switch (event.sensor.getType()) {
			case Sensor.TYPE_MAGNETIC_FIELD:
				magneticValues = event.values.clone();
				break;
			case Sensor.TYPE_ACCELEROMETER:
				accelerometerValues = event.values.clone();
                break;
		}

		if (magneticValues != null && accelerometerValues != null) {

			SensorManager.getRotationMatrix(inR, I, accelerometerValues, magneticValues);

			// Correct if screen is in Landscape
			SensorManager.remapCoordinateSystem(inR, SensorManager.AXIS_X, SensorManager.AXIS_Z, outR);
			SensorManager.getOrientation(outR, orientationValues);

			Log.v("Orientation",
	            String.valueOf( radianToDegree(orientationValues[0]) ) + ", " + //Z軸方向,azmuth
	            String.valueOf( radianToDegree(orientationValues[1]) ) + ", " + //X軸方向,pitch
   	            String.valueOf( radianToDegree(orientationValues[2]) ) );       //Y軸方向,roll

			//描画更新
			view.invalidate();
		}
	}


	int radianToDegree(float rad){
		return (int) Math.floor( Math.toDegrees(rad) ) ;
	}

	// 角度から画面回転を求める
	float roundOrientationDegree(float roll){

		//inputのroll(Y軸のDegree)は-180～180の範囲を想定
		if(-225 < roll  && roll <= -135  )return  180.0f;
		if(-135 < roll  && roll <=  -45  )return   90.0f;
		if( -45 < roll  && roll <=   45  )return    0.0f;
		if(  45 < roll  && roll <=  135  )return  -90.0f;
		if( 135 < roll  && roll <=  225  )return -180.0f;

		return 0.0f;
	}

	// 回転処理専用Viewを作成
	class ContentView extends View {

		Bitmap bitmap;//画像保存用

		public ContentView(Context context) {
			super(context);

			//Bitmapをリソースから取得
			bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.android_logo);
	    }

		@Override
		public void onDraw(Canvas canvas) {

			Paint paint = new Paint();
			Bitmap rotetaBitmap;

			//Bitmapを回転する
			// Bitmap のサイズの取得
			int width = bitmap.getWidth();
			int height = bitmap.getHeight();

			float degree  = radianToDegree(orientationValues[2]);
			float roll = roundOrientationDegree( degree );

			Matrix matrix = new Matrix();
			matrix.postRotate(roll);  // 回転させる角度を指定

			rotetaBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);

			//描画処理drawBitmapは(Bitmap,x座標,y座標,Paint)
			canvas.drawBitmap(rotetaBitmap, 0, 0, paint);
	    }
	}
}
