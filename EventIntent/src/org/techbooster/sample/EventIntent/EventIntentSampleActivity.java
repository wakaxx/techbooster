package org.techbooster.sample.EventIntent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EventIntentSampleActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// カレンダーアプリを呼び出すIntentの生成
				Intent intent = new Intent(Intent.ACTION_INSERT,
						Events.CONTENT_URI);
				//スケジュールのタイトル
				intent.putExtra(Events.TITLE, "タイトル");
				//スケジュールの開始時刻 ゼロで現在時刻
				intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, 0);
				//スケジュールの終了時刻　ゼロでぜんざい時刻＋１時間
				intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, 0);
				//スケジュールの場所
				intent.putExtra(Events.EVENT_LOCATION, "大阪");
				//スケジュールの詳細内容
				intent.putExtra(Events.DESCRIPTION, "サンプル");
				//スケジュールに招待するメールアドレス
				intent.putExtra(Intent.EXTRA_EMAIL, "hoge@hoge.com");
				//スケジュールのアクセスレベル
				intent.putExtra(Events.ACCESS_LEVEL, Events.ACCESS_DEFAULT);
				//スケジュールの同時持ちの可否
				intent.putExtra(Events.AVAILABILITY, Events.AVAILABILITY_FREE);
				//Intentを呼び出す
				startActivity(intent);
			}
		});
	}
}