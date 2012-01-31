package org.techbooster;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SystemOverlayLayerActivity extends Activity {
	Button start_button;
	Button stop_button;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        start_button = (Button) findViewById(R.id.start_button);
        stop_button = (Button) findViewById(R.id.stop_button);
        
        final OnClickListener onStartButton = new OnClickListener() {
			@Override
			public void onClick(View v) {
        		startService(new Intent(SystemOverlayLayerActivity.this, MusicService.class));
			}
        };
        start_button.setOnClickListener(onStartButton);

        final OnClickListener onStopButton = new OnClickListener() {
			@Override
			public void onClick(View v) {
        		stopService(new Intent(SystemOverlayLayerActivity.this, MusicService.class));
			}
        };
        stop_button.setOnClickListener(onStopButton);
    }
}