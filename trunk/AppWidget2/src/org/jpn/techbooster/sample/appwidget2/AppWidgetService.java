package org.jpn.techbooster.sample.appwidget2;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

public class AppWidgetService extends Service {
	private final String BUTTON_CLICK_ACTION = "BUTTON_CLICK_ACTION"; 
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		
		// ボタンが押された時に発行されるインテントを準備する
		Intent buttonIntent = new Intent();
		buttonIntent.setAction(BUTTON_CLICK_ACTION);
		PendingIntent pendingIntent = PendingIntent.getService(this, 0, buttonIntent, 0);
		RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.main);	
		remoteViews.setOnClickPendingIntent(R.id.button, pendingIntent);
		
		// ボタンが押された時に発行されたインテントの場合は文字を変更する
		if (BUTTON_CLICK_ACTION.equals(intent.getAction())) {
			remoteViews.setTextViewText(R.id.text, "Push Button");
		}		

		// AppWidgetの画面更新
		ComponentName thisWidget = new ComponentName(this, AppWidget2.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        manager.updateAppWidget(thisWidget, remoteViews);
   	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
