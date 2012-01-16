package org.jpn.techbooster.sample.getuserprofilesample;

import com.kobashin.sample.userprofile.R;

import android.app.Activity;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GetUserProfileSampleActivity extends Activity implements
		OnClickListener {
	TextView tv;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/* set View */
		((Button) findViewById(R.id.button1)).setOnClickListener(this);
		tv = (TextView) findViewById(R.id.textView1);
	}

	@Override
	public void onClick(View v) {
		/* Get UserProfile */

		// Cursorの取得
		Cursor mCursor = getContentResolver().query(
				ContactsContract.Profile.CONTENT_URI, null, null, null, null);

		mCursor.moveToFirst();

		// UserNameの取得
		int nameIndex = mCursor
				.getColumnIndex(ContactsContract.Profile.DISPLAY_NAME);
		String uName = mCursor.getString(nameIndex);

		// Phone Numberの取得
		int hasPhoneNumIndex = mCursor
				.getColumnIndex(ContactsContract.Profile.HAS_PHONE_NUMBER);
		String hasNumber = mCursor.getString(hasPhoneNumIndex);

		// ProfileレコードのIDを取得する
		int idIndex = mCursor.getColumnIndex(ContactsContract.Profile._ID);
		long _id = mCursor.getLong(idIndex);

		// ProfileのURLから取得したCursorを閉じる
		mCursor.close();
		
		
		String phoneNumber = "No Data";
		// 取得したIDからNumberの取得
		if (hasNumber.equals("1")) {

			// ProfileのContent_Uriから取得したIDから、Phone情報のUriを取得する
			Uri pUri = ContentUris.withAppendedId(
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI, _id);

			// UriからCursorを取り出す
			mCursor = managedQuery(pUri, null, null, null, null);
			mCursor.moveToFirst();

			// Cursorを使い、PhoneNumberを取得する
			phoneNumber = mCursor
					.getString(mCursor
							.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

			// Close Cursor
			mCursor.close();
		
		}

		// TextViewを表示する
		StringBuilder sb = new StringBuilder();
		sb.append("User Name : ");
		sb.append(uName);
		sb.append("\n");
		sb.append("Phone Number : ");
		sb.append("\n");
		sb.append(phoneNumber);

		tv.setText(sb.toString());



	}

}