package org.jpn.techbooster.sample.CopyUriSample;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

public class PasteImage extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);
	}

	private void startBrowser(){
    	//システムのクリップボードオブジェクトを取得
		ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

		//クリップボードからUriを取得
		Uri uri = cm.getPrimaryClip().getItemAt(0).getUri();

		//ContentResolverを取得
		ContentResolver cr = getContentResolver();

		//クリップボードから取得したUriのMime Typeを取得
		String mimeType = cr.getType(uri);

		if(mimeType != null){
			//MIME_TYPEが取得したいデータのものであるか確認
			if(mimeType.equals("")){
				Cursor pasteCursor = cr.query(uri, null, null, null, null);
				if(pasteCursor != null){
					if(pasteCursor.moveToFirst()){
						//データ取得処理
					}
				}
			}
		}
    }
}
