/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.accelerometer;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class accelerometerActivity extends Activity  implements SensorEventListener{


	/* センサーマネージャ */
    private SensorManager mSensorManager;
    private boolean mIsSensor;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /* センサーマネージャを取得する */
        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
    }

    //* onResume */
    @Override
    protected void onResume() {
    	// TODO 自動生成されたメソッド・スタブ
    	super.onResume();

    	// 傾き検知
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        // センサマネージャへリスナーを登録(implements SensorEventListenerにより、thisで登録する)
        if (sensors.size() > 0) {
            Sensor sensor = sensors.get(0);
            mIsSensor = mSensorManager.registerListener(this,
                sensor,
                SensorManager.SENSOR_DELAY_UI);

            /*
             * int	SENSOR_DELAY_FASTEST	get sensor data as fast as possible
             * int 	SENSOR_DELAY_GAME		rate suitable for games
             * int 	SENSOR_DELAY_NORMAL 	rate (default) suitable for screen orientation changes
             * int 	SENSOR_DELAY_UI 		rate suitable for the user interface
             */
        }
    }

    //* onPause */
    @Override
    protected void onPause() {
    	// TODO 自動生成されたメソッド・スタブ
    	super.onPause();

    	//センサーマネージャのリスナ登録破棄
        if (mIsSensor) {
            mSensorManager.unregisterListener(this);
            mIsSensor = false;
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
        /*
    	Log.v("Activity",
                String.valueOf(event.values[0]) + ", " + //使わないZ軸方向
                String.valueOf(event.values[1]) + ", " + //画像のX軸方向
                String.valueOf(event.values[2]));		 //画像のY軸方向
		*/

    	/*
    	if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
       		mSensor.set(event.values[1],-1*event.values[2]);
    	}else if( getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
    		mSensor.set(event.values[2],event.values[1]);
    	}
    	*/
    }

}