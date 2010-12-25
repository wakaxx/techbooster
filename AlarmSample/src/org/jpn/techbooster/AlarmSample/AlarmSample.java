package org.jpn.techbooster.AlarmSample;

import java.util.Calendar;
import android.app.Activity;
import android.os.Bundle;
import android.app.AlarmManager;
import android.content.Intent;
import android.app.PendingIntent;

public class AlarmSample extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Intent i = new Intent(getApplicationContext(), ReceivedActivity.class); // ReceivedActivityを呼び出すインテントを作成
		PendingIntent pi = PendingIntent.getBroadcast(AlarmSample.this, 0, i, 0); // ブロードキャストを投げるPendingIntentの作成

		Calendar cal = Calendar.getInstance(); // Calendar取得
		cal.setTimeInMillis(System.currentTimeMillis()); // 現在時刻を取得
		cal.add(Calendar.SECOND, 15); // 現時刻より15秒後を設定

		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE); // AlramManager取得
		am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi); // AlramManagerにPendingIntentを登録
	}
}
