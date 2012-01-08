package org.techbooster.sample.Intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// buttonを取得
		Button btn = (Button) findViewById(R.id.Button01);
		btn.setOnClickListener(this);
	}

	// インターフェイスを実装 implements OnClickListener
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClassName("org.techbooster.sample.Intent",
				"org.techbooster.sample.Intent.SubActivity");
		intent.putExtra("org.techbooster.sample.Intent.testString",
				"!TEST STRING!");

		startActivity(intent);

	}
}