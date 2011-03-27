package org.jpn.techbooster.CopyIntentSample;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class CopyIntentSample extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //アダプター作成
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //スピナーのリストアイテム作成
        adapter.add("");
        adapter.add("ブラウザ");
        adapter.add("カメラ");

        //スピナーをデザインから取得
        Spinner sp = (Spinner)findViewById(R.id.spinner1);

        //アダプターをスピナーに設定
        sp.setAdapter(adapter);

        //アイテム選択時処理
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Spinner sp = (Spinner)arg0;
				copyIntent(sp.getSelectedItem().toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});

        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startCopiedIntent();
			}
		});

    }

    private void copyIntent(String selected){
    	if(selected.equals("ブラウザ")){
    		//ブラウザで開くURI設定
    		Uri uri = Uri.parse("http://techbooster.jpn.org/");
    		//コピーするIntentを作成
    		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    		//システムのクリップボードオブジェクトを取得
    		ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    		//Intentのクリップデータを作成
    		ClipData cd = ClipData.newIntent("Intent", intent);
    		//Intentをクリップボードへコピー
    		cm.setPrimaryClip(cd);
    	}else if(selected.equals("カメラ")){
    		//コピーするIntentを作成
    		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    		//システムのクリップボードオブジェクトを取得
    		ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    		//Intentのクリップデータを作成
    		ClipData cd = ClipData.newIntent("Intent", intent);
    		//Intentをクリップボードへコピー
    		cm.setPrimaryClip(cd);
    	}
    }

    private void startCopiedIntent(){
    	//システムのクリップボードオブジェクトを取得
    	ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
    	//クリップボードからコピーされているIntentを取得
    	Intent intent = cm.getPrimaryClip().getItemAt(0).getIntent();
    	//Intentの取得正否確認
    	if(intent != null){
    		//Intentを起動
    		startActivity(intent);
    	}else{
    		Toast.makeText(getApplicationContext(), "Intentを選択してください", Toast.LENGTH_SHORT);
    	}
    }
}