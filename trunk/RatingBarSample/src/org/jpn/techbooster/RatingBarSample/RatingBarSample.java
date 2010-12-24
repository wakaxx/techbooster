package org.jpn.techbooster.RatingBarSample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarSample extends Activity implements
		RatingBar.OnRatingBarChangeListener {
	/** Called when the activity is first created. */
	RatingBar RatingBar;
	Toast mToast;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		RatingBar = (RatingBar) findViewById(R.id.ratingbar);
		RatingBar.setOnRatingBarChangeListener(this);
	}

	// レイティングバーが変更されたときに呼ばれる
	public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromTouch) {
		if (mToast != null) {
			mToast.cancel();
		}

		// 現在のレートをToastで表示する
		mToast = Toast.makeText(RatingBarSample.this, "Current Rating is "
				+ RatingBar.getRating(), Toast.LENGTH_LONG);
		mToast.show();
	}
}