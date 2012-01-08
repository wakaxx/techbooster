package org.techbooster.sample.implicitIntent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SendIntentActivity extends Activity {
	static final int MY_INTENT_BROWSER = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case (R.id.button_brows):
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://techbooster.org/"));
			break;
		case (R.id.button_map):
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("geo:0,0?q=Osaka"));
			break;
		case (R.id.button_market):
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("market://details?id=com.udg.goodmorning.tweet"));
			break;
		case (R.id.button_dial):
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:123456789"));
			break;
		case (R.id.button_string):
			intent = new Intent();
			intent.setAction(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.putExtra(Intent.EXTRA_TEXT, "トゥットゥルー");
			break;
		case (R.id.button_mail):
			intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
			intent.putExtra(Intent.EXTRA_SUBJECT, "タイトル");
			intent.putExtra(Intent.EXTRA_TEXT, "トゥットゥルー");
			break;
		}
		if (intent != null)
			startActivityForResult(intent, MY_INTENT_BROWSER);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// 返り値の取得
		if (requestCode == MY_INTENT_BROWSER) {
			if (resultCode == RESULT_OK) {
				// Success
				Log.d("IntentSample", "success");
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
				Log.d("IntentSample", "canceled");

			}
		}
	}
}