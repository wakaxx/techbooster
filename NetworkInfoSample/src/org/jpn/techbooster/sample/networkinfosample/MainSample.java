package org.jpn.techbooster.sample.networkinfosample;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainSample extends Activity implements OnClickListener {
	ConnectivityManager cm;
	ImageView iv;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/* ConnectivityManagerの取得 */
		cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

		/* コンポーネントの接続 */
		Button bt = (Button) findViewById(R.id.checkbutton);
		bt.setOnClickListener(this);

		iv = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public void onClick(View v) {
		NetworkInfo nInfo = cm.getActiveNetworkInfo();

		if (nInfo == null) {
			Toast.makeText(this, "No Network Connection!", Toast.LENGTH_LONG)
					.show();
			iv.setImageResource(R.drawable.indicator_input_error);
			return;
		}

		if (nInfo.isConnected()) {
			/* NetWork接続可 */
			Toast.makeText(this, nInfo.getTypeName() + "接続なう",
					Toast.LENGTH_LONG).show();
			if (nInfo.getTypeName().equals("WIFI")) {
				iv.setImageResource(R.drawable.wifi);
			} else if (nInfo.getTypeName().equals("mobile")) {
				iv.setImageResource(R.drawable.mobile);
			}

		} else {
			/* NetWork接続不可 */
			Toast.makeText(this, "No Network Connection!", Toast.LENGTH_LONG)
					.show();
			iv.setImageResource(R.drawable.indicator_input_error);
		}
	}

}