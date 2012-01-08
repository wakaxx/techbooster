package org.techbooster.sample.RatingBar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;

public class RatingBarActivity extends Activity {
	RatingBar rb;
	TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		rb = new RatingBar(this);
		tv = new TextView(this);

		layout.addView(rb);
		layout.addView(tv);
		setContentView(layout);

		// 星の数を７に設定
		rb.setNumStars(7);
		// レートの変更を可能にする
		rb.setIsIndicator(false);
		// レートが加減される時のステップ幅を0.5に設定
		rb.setStepSize((float) 0.5);
		// レートの初期値を2.0に設定
		rb.setRating((float) 2.0);

		rb.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				// レートが変更された際の処理
				tv.setText("今のレート：" + ratingBar.getRating() + "/"
						+ ratingBar.getNumStars());
				// レートの量によってテキストのサイズを変える
				tv.setTextSize(ratingBar.getRating() * 5);
			}
		});
	}
}