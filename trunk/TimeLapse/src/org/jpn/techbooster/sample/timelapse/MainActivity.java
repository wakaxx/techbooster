package org.jpn.techbooster.sample.timelapse;

import android.app.Activity;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends Activity implements SurfaceHolder.Callback {
	private MediaRecorder myRecorder;
	private boolean isRecording;
	SurfaceHolder v_holder;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		SurfaceView mySurfaceView = (SurfaceView) findViewById(R.id.surface_view);
		SurfaceHolder holder = mySurfaceView.getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		myRecorder = new MediaRecorder(); // MediaRecorderのインスタンスを作成
	}

	public void surfaceCreated(SurfaceHolder holder) {
		//
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		v_holder = holder; // SurfaceHolderを保存
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		//
	}

	public void initializeVideoSettings() {
		myRecorder.setVideoSource(MediaRecorder.VideoSource.DEFAULT); // 録画の入力ソースを指定
		myRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_TIME_LAPSE_720P));
		myRecorder.setCaptureRate(4);	// XOOMの場合 MIN 4.000fps MAX 35.000fps
		myRecorder.setOutputFile(Environment.getExternalStorageDirectory().toString() + "/sample2.mp4"); // 動画の出力先となるファイルパスを指定
		myRecorder.setPreviewDisplay(v_holder.getSurface()); // 録画中のプレビューに利用するサーフェイスを指定する

		/*
		Camera camera = Camera.open();
		Parameters parameters = camera.getParameters();
		int fps[] = new int[2];
		parameters.getPreviewFpsRange(fps);
		Log.e("TimeLapse", String.valueOf(fps[0]));
		Log.e("TimeLapse", String.valueOf(fps[1]));
		camera.release();
		*/
		
		try {
			myRecorder.prepare(); //
		} catch (Exception e) {
			Log.e("TimeLapse", e.getMessage());
		}
	}

	// タッチパネルが押されたら録画開始/録画停止
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			// 録画中でなければ録画を開始
			if (!isRecording) {
				initializeVideoSettings(); // MediaRecorderの設定
				myRecorder.start(); // 録画開始
				isRecording = true; // 録画中のフラグを立てる

			// 録画中であれば録画を停止
			} else {
				myRecorder.stop(); // 録画停止
				myRecorder.reset(); // オブジェクトのリセット
				isRecording = false; // 録画中のフラグを外す
			}
		}
		return true;
	}
}
