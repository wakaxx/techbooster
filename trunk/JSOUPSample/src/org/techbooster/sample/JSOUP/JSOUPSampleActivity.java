package org.techbooster.sample.JSOUP;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class JSOUPSampleActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		String url = "http://techbooster.org/";

		try {
			// HTMLのドキュメントを取得
			Document document = Jsoup.connect(url).get();

			// titleタグを取得
			Elements title = document.getElementsByTag("title");
			// こちらでもtitleを取得できる
			// String title = document.title();

			// bodyタグをIDから取得
			Elements body = document.getElementsByTag("body");
			// こちらでもbodyを取得できる
			//Element body = document.body();

			TextView tv = (TextView) findViewById(R.id.textView1);
			tv.setText(title.toString() + "\n" + body.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}