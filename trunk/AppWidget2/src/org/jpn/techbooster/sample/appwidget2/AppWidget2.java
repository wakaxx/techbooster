package org.jpn.techbooster.sample.appwidget2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class AppWidget2 extends AppWidgetProvider {
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		
		// サービスの起動
		Intent intent = new Intent(context, AppWidgetService.class);
		context.startService(intent);
	}
}
