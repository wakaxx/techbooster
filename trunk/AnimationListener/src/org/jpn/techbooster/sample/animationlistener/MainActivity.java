package org.jpn.techbooster.sample.animationlistener;

import org.jpn.techbooster.sample.animationlistener.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, AnimationListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.StartButton);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		ImageView img = (ImageView) findViewById(R.id.ImageView);
		RotateAnimation rotate = new RotateAnimation(0, 360,
				img.getWidth() / 2, img.getHeight() / 2);
		rotate.setDuration(3000);
		rotate.setRepeatCount(2);
		rotate.setAnimationListener(this);
		img.startAnimation(rotate);
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		Toast.makeText(this, "AnimationEnd", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		Toast.makeText(this, "AnimationRepeat", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onAnimationStart(Animation animation) {
		Toast.makeText(this, "AnimationStart", Toast.LENGTH_SHORT).show();
	}
}