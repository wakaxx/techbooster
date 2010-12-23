/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.mediarecorderActivity;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MediaRecorderActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button startBtn = (Button) findViewById(R.id.Start);
        startBtn.setOnClickListener(this);
        Button stopBtn  = (Button) findViewById(R.id.Stop);
        stopBtn.setOnClickListener(this);

    }

    MediaRecorder recorder;

	public void onClick(View v) {
		// Activity implements OnClickListener

		switch(v.getId()){

		case R.id.Start:	//スタートボタン押下

			recorder = new MediaRecorder();
		    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

		    //保存先
		    String filePath = Environment.getExternalStorageDirectory() + "/audio.3gp";
		    recorder.setOutputFile(filePath);

		    //録音準備＆録音開始
		    try {
				recorder.prepare();
			} catch (Exception e) {
				e.printStackTrace();
			}
			recorder.start();	//録音開始
		    break;

		case R.id.Stop:			//ストップボタン押下
		    recorder.stop();
		    recorder.reset();   //オブジェクトのリセット
			//release()前であればsetAudioSourceメソッドを呼び出すことで再利用可能
		    recorder.release(); //Recorderオブジェクトの解放
		    break;


		}

	}
}