package org.techbooster;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SensorActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private TextView mTextView;
    private ImageView mImageView;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        // SensorManagerのインスタンスを取得する
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
 
        // ImageViewのインスタンスを取得して、画像を設定する
        mImageView = (ImageView) findViewById(R.id.image);
        mImageView.setImageResource(R.drawable.tb);
 
        // TextViewのインスタンスを取得する
        mTextView = (TextView) findViewById(R.id.value);
 
    }
 
    @Override
    protected void onResume() {
        super.onResume();
 
        // 照度センサーを指定してオブジェクトリストを取得する
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_LIGHT);
 
        // 照度センサーがサポートされているか確認してから登録する
        if (sensors.size() > 0) {
            Sensor s = sensors.get(0);
            mSensorManager.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
        }
    }
 
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // onAccuracyChangedは今回は未使用
    }
 
    @Override
    public void onSensorChanged(SensorEvent event) {
        switch(event.sensor.getType()){
        case Sensor.TYPE_LIGHT:
            // 現在の明るさを取得
            int light_value = (int)(event.values[0]);
 
            // 明るさが200未満のときのセリフ
            if (light_value < 200) {
                mTextView.setText("暗いから眠くなってきたにゃ。");
 
            // 明るさが200以上のときのセリフ
            } else {
                mTextView.setText("明るすぎて眼が痛いにゃ。");
            }
 
            // 明るさから透明度を求める
            int alpha = light_value;
            if (alpha > 255) // 透明度の上限値を255に設定する
                alpha = 255;
 
            // ImageViewに透明度を設定する
            mImageView.setAlpha(alpha);
 
            break;
        }
    }
}
