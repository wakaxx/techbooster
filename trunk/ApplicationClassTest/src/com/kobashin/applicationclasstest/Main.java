package com.kobashin.applicationclasstest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener {
	private Bitmap bmp_main;
	private TestApplication ta;
	private Button bt;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/* getApplication()で自己アプリケーションクラスのインスタンスを拾う */
		ta = (TestApplication) this.getApplication();

		bt = (Button) findViewById(R.id.Button01);
		bt.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if (v == bt) {
			bmp_main = BitmapFactory.decodeResource(getResources(),
					R.drawable.andy);

			ta.setObj(bmp_main);

			Intent i = new Intent();
			i.setClassName("com.kobashin.applicationclasstest",
					"com.kobashin.applicationclasstest.Sub");
			startActivity(i);
		}
	}

}