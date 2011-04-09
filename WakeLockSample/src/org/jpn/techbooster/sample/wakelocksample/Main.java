package org.jpn.techbooster.sample.wakelocksample;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button bt = (Button)findViewById(R.id.button1);
        bt.setOnClickListener(this);
        
        
    }

    @Override
	public void onClick(View v) {
		/* 一定時間後に処理をさせるために、PendingIntent と AlarmManagerを利用する */
		Intent wakeLockIntent = new Intent(getApplicationContext(),Receiver.class);
		wakeLockIntent.setAction("org.jpn.techbooster.sample.action.start");
		PendingIntent pi = PendingIntent.getBroadcast(Main.this, 0, wakeLockIntent, 0);
		
		/* 今より10秒後のデータを作成 */
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.SECOND, 10);
		
		/* AlarmManagerをセット */
		AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
		
		finish();
	}
}