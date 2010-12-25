package com.udg.sample.thumb;

import java.io.FileOutputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ThumbnailSampleActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thumb);

		WebView web = new WebView(this);
		setContentView(web);
		CharSequence uri = getIntent().getExtras().getCharSequence(
				Intent.EXTRA_TEXT);
		String ss = uri.toString();
		web.loadUrl(uri.toString());

		web.setWebViewClient(new WebViewClient() {
			public void onPageFinished(WebView view, String url) {
				Picture picture = view.capturePicture();

				Bitmap b = Bitmap.createBitmap(500, 500,
						Bitmap.Config.ARGB_8888);

				Canvas c = new Canvas(b);

				picture.draw(c);

				FileOutputStream fos = null;

				try {

					fos = new FileOutputStream(Environment
							.getExternalStorageDirectory().toString()
							+ "/test.jpg");

					if (fos != null) {
						b.compress(Bitmap.CompressFormat.JPEG, 90, fos);

						fos.close();
					}

				} catch (Exception e) {
					//省略。。
				}
			}
		});

	}

}
