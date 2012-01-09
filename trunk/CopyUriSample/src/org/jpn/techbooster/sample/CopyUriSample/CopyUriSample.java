package org.jpn.techbooster.sample.CopyUriSample;

import java.util.Currency;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class CopyUriSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				copyUri();
			}
		});

        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				startBrowser();
			}
		});
    }

    private void copyUri(){
    	//外部メモリから画像のUriを取得
    	Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

		//ClipDataオブジェクトの作成
		ClipData cd = ClipData.newUri(getContentResolver(), "Uri", uri);

    	//システムのクリップボードオブジェクトを取得
		ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

		//Uriをクリップボードへコピー
		cm.setPrimaryClip(cd);
    }

    private void startBrowser(){
    	EditText ed = (EditText)findViewById(R.id.editText1);
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
			if(mimeType.equals(MediaStore.Images.Media.CONTENT_TYPE)){
				Cursor pasteCursor = cr.query(uri, null, null, null, null);
				if(pasteCursor != null){
					if(pasteCursor.moveToFirst()){
						//データ取得処理
						ImageView iv = (ImageView)findViewById(R.id.imageView1);
						iv.setImageURI(uri);
					}
				}
			}
		}
    }
}