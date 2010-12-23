/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.orientationSensor;

import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class orientationSensorActivity extends Activity  implements SensorEventListener{

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


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

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
		}
	}


	int radianToDegree(float rad){
		return (int) Math.floor( Math.toDegrees(rad) ) ;
	}

}