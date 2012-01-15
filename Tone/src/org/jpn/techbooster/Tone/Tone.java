package org.jpn.techbooster.Tone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.media.ToneGenerator;

public class Tone extends Activity {
	ToneGenerator tg;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tg = new ToneGenerator(android.media.AudioManager.STREAM_DTMF, ToneGenerator.MAX_VOLUME);
		
		Button startButton = (Button) findViewById(R.id.startButton);
		startButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tg.startTone(ToneGenerator.TONE_DTMF_0, 5000);	
			}
		});
		Button stopButton = (Button) findViewById(R.id.stopButton);
		stopButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				tg.stopTone();
			}
		});
	}
}
