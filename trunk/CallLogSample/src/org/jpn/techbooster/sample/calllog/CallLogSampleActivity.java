package org.jpn.techbooster.sample.calllog;

import java.util.Date;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.util.Log;

public class CallLogSampleActivity extends Activity {
	private static final String TAG = "CallLogSample";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ContentResolver contentResolver = getContentResolver();

		// ソートする条件
		String order = CallLog.Calls.DEFAULT_SORT_ORDER;

		Cursor cursor = contentResolver.query(
				CallLog.Calls.CONTENT_URI,
				null,
				null,
				null,
				order
		);

		if (cursor.moveToFirst()) { 
			do {
				String number = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
				String cachedName = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
				String type = cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE));
				Date date = new Date(cursor.getLong(cursor.getColumnIndex(CallLog.Calls.DATE)));
				
				Log.d(TAG, "DATE : " + date);
				Log.d(TAG, "NUMBER : " + number);
				Log.d(TAG, "CACHED_NAME : " + cachedName);
				Log.d(TAG, "TYPE : " + type);
			} while (cursor.moveToNext());
		}
	}
}