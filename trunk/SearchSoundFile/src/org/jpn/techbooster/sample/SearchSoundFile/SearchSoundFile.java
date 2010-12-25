package org.jpn.techbooster.sample.SearchSoundFile;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SearchSoundFile extends Activity {
	Button search_button;
	EditText title_edittext, artist_edittext;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		search_button = (Button) findViewById(R.id.search_button);
		title_edittext = (EditText) findViewById(R.id.title_edittext);
		artist_edittext = (EditText) findViewById(R.id.artist_edittext);

		search_button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String title = title_edittext.getText().toString();
				String artist = artist_edittext.getText().toString();

				Intent i = new Intent(); // インテントを作成
				i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				i.setAction(MediaStore.INTENT_ACTION_MEDIA_SEARCH); // INTENT_ACTION_MEDIA_SEARCHアクションインテントを発行する
				i.putExtra(SearchManager.QUERY, title+" "+artist); // 検索キーを指定
				i.putExtra(MediaStore.EXTRA_MEDIA_TITLE, title); // タイトルを指定
				i.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artist); // アーティストを指定
				startActivity(i);
			}
		});
	}
}