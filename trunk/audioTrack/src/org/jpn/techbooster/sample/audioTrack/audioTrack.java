package org.jpn.techbooster.sample.audioTrack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class audioTrack extends Activity implements Runnable {
	Button play_button, stop_button;
	File file = null;
	byte[] byteData = null;
	Boolean playing = false;
	int bufSize;
	AudioTrack myAT = null;
	Thread play_thread = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ボタンのインスタンスを作成
		play_button = (Button) findViewById(R.id.play_button);
		stop_button = (Button) findViewById(R.id.stop_button);

		// WAVEファイルのFileインスタンスを作成
		file = new File("/sdcard/strings.wav");
		
		// WAVEファイルのサイズを取得
		byteData = new byte[(int) file.length()];

		// WAVEファイルをロード
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			in.read(byteData);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 再生用初期化処理
		initialize();

		// プレイボタン
		play_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 再生用スレッドを起こす
				play_thread.start();
			}
		});

		// ストップボタン
		stop_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 再生中なら停止させる
				if (myAT.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
					myAT.stop();
					play_thread = null;
					initialize();
				}
			}
		});
	}

	// 再生用初期化処理
	void initialize() {
		// 必要となるバッファサイズを計算
		bufSize = android.media.AudioTrack.getMinBufferSize(44100,
				AudioFormat.CHANNEL_CONFIGURATION_MONO,
				AudioFormat.ENCODING_PCM_16BIT);
		
		// AudioTrackインスタンス作成
		myAT = new AudioTrack(AudioManager.STREAM_MUSIC,
				44100, AudioFormat.CHANNEL_CONFIGURATION_MONO,
				AudioFormat.ENCODING_PCM_16BIT, bufSize,
				AudioTrack.MODE_STREAM);
		
		// スレッドインスタンス作成
		play_thread = new Thread(this);
	}
	
	// 再生用スレッド処理
	public void run() {
		if (myAT != null) {
			// 再生開始
			myAT.play();
			myAT.write(byteData, 0, byteData.length);
		}
	}
}
