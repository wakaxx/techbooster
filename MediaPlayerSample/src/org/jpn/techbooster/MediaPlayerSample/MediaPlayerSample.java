package org.jpn.techbooster.MediaPlayerSample;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MediaPlayerSample extends Activity implements OnClickListener {
	MediaPlayer mp = null;
	Button play_button;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mp = MediaPlayer.create(this, R.raw.hana);	// hana.mp3を指定してMediaPlayerを作成する
															// 使用曲は「フリーBGM　Music with myuu」様より「花のワルツ」

		play_button = (Button) findViewById(R.id.PlayButton);
		play_button.setOnClickListener(this);
	}

	public void onClick(View v) {
		if (mp.isPlaying()) { // 再生中の場合は再生を停止する
			play_button.setText("Music Start");
			mp.stop();
			try {
				mp.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 停止中の場合は再生を開始する
			play_button.setText("Music Stop");
			mp.start();
		}
	}
}