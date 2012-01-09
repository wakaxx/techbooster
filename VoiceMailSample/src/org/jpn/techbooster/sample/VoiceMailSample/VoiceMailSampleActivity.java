package org.jpn.techbooster.sample.VoiceMailSample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract.RawContacts;
import android.provider.VoicemailContract;
import android.util.Log;
import android.widget.TextView;

public class VoiceMailSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	ContentValues values = new ContentValues();
	values.clear();
	// 送信時間の設定(ここでは仮に現在時刻を設定)
//	values.put(VoicemailContract.Voicemails.DATE, Calendar.getInstance()
//		.getTimeInMillis());

	// VoiceMailの再生時間を設定
//	values.put(VoicemailContract.Voicemails.DURATION, 1000);

	// 既読かどうか
//	values.put(VoicemailContract.Voicemails.IS_READ, false);

	// MYME TYPEの設定
//	values.put(VoicemailContract.Voicemails.MIME_TYPE, "audio/mpeg");

	// 送信者の電話番号
//	values.put(VoicemailContract.Voicemails.NUMBER, "09012345678");

	// VoiceMailのデータ本体
//	values.put(VoicemailContract.Voicemails.SOURCE_DATA, "");

	// VoiceMailを保存したアプリのパッケージ名
	values.put(VoicemailContract.Voicemails.SOURCE_PACKAGE,
		getPackageName());

	// VoiceMailの保存
	Uri dataSetUri = getContentResolver().insert(
		VoicemailContract.Voicemails.buildSourceUri(getPackageName()),
		values);

	TextView tv = (TextView) findViewById(R.id.text);
	tv.setText(dataSetUri.toString());
    }
}