package org.jpn.techbooster.VolumeControl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.media.AudioManager;

public class VolumeControl extends Activity {
	AudioManager am;
	SeekBar ringVolSeekBar;
	SeekBar notifyVolSeekBar;
	TextView ringVolText;
	TextView notifyVolText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// AudioManagerを取得
		am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		
		// 現在の着信音量の取得
		int ringVolume = am.getStreamVolume(AudioManager.STREAM_RING); 
		// 現在の通知音量の取得
		int notificationVolume = am.getStreamVolume(AudioManager.STREAM_NOTIFICATION); 

		ringVolSeekBar = (SeekBar) findViewById(R.id.ringVolSeekBar);
		ringVolSeekBar.setProgress(ringVolume); // 着信音量用シークバーに現在の着信音量を表示
		ringVolText = (TextView) findViewById(R.id.ringVolText);
		ringVolText.setText("Ring Volume: " + ringVolume); // 着信音量用TextViewに現在の着信音量を表示

		notifyVolSeekBar = (SeekBar) findViewById(R.id.notifyVolSeekBar);
		notifyVolSeekBar.setProgress(notificationVolume); // 通知音量用シークバーに現在の着信音量を表示
		notifyVolText = (TextView) findViewById(R.id.notifyVolLabel);
		notifyVolText.setText("Notification Volume: " + notificationVolume); // 通知音量用TextViewに現在の通知音量を表示

		// 着信音量用シークバーが変更されたら呼ばれる
		ringVolSeekBar
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						// TODO Auto-generated method stub
						ringVolText.setText("Ring Volume:" + progress);
						am.setStreamVolume(AudioManager.STREAM_RING, progress, 0); // シークバーの値を着信音量に設定する
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
					}
				});

		// 通知音量用シークバーが変更されたら呼ばれる
		notifyVolSeekBar
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						// TODO Auto-generated method stub
						notifyVolText.setText("Notification Volume:" + progress);
						am.setStreamVolume(AudioManager.STREAM_NOTIFICATION, progress, 0); // シークバーの値を通知音量に設定する
					}

					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
					}

					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
					}
				});
	}
}
