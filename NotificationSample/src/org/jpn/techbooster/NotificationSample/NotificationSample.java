package org.jpn.techbooster.NotificationSample;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationSample extends Activity {
	private NotificationManager mManager;
	private int number = 0;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        Button b = (Button)findViewById(R.id.notify);

        // ボタンを押したらノーティフィケーションを送信
        b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				sendNotification();
			}
		});
    }
    
    // ノーティフィケーション送信用関数
    private void sendNotification() {
        mManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        
    	Notification n = new Notification();
    	Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567890")); // ノーティフィケーションに電話アプリのインテントを設定
    	PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0); 
    	
    	n.icon = R.drawable.coda; // アイコンの設定
    	n.tickerText = "NotificationSample"; // ステータスバーに表示されるティッカー文字列
    	n.number = number; // ステータスバー上のアイコンに重ねて表示される文字列
    	
    	n.setLatestEventInfo(getApplicationContext(), "NotificationSample", "It calls it.", pi);

    	mManager.notify(number, n); // ノーティフィケーション送信
    	number++; // 識別子をインクリメント
    }
}
