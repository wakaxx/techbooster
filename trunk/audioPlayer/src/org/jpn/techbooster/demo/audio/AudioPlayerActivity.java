package org.jpn.techbooster.demo.audio;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class AudioPlayerActivity extends Activity {

	private MediaPlayer mp;
	private String path;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        //リソースファイルから再生
        mp = MediaPlayer.create(this, R.raw.music);
        mp.start();

        //ローカルファイルを再生
        mp = new MediaPlayer();
        try {
			mp.setDataSource(path);
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        try {
			mp.prepare();
		} catch (IllegalStateException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        mp.start();


    }
}