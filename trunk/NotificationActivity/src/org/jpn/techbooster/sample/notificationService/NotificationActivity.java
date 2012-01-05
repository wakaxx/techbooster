package org.jpn.techbooster.sample.notificationService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button startButton = (Button) findViewById(R.id.StartButton);
        Button stopButton  = (Button) findViewById(R.id.StopButton);

        startButton.setOnClickListener(startListener);
        stopButton.setOnClickListener(stopListener);
    }

    private OnClickListener startListener = new OnClickListener() {
        public void onClick(View v) {
            startService(new Intent(NotificationActivity.this,
            		NotificationChangeService.class));
        }
    };

    private OnClickListener stopListener = new OnClickListener() {
        public void onClick(View v) {
            stopService(new Intent(NotificationActivity.this,
            		NotificationChangeService.class));
        }
    };
}