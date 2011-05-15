package org.jpn.techbooster.HoneycombClipboardManagerSample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;

public class HoneycombClipboardManagerSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //コピーボタン
        Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText et = (EditText)findViewById(R.id.editText1);

				//クリップボードに格納するItemを作成
				ClipData.Item item = new ClipData.Item(et.getText());

				//MIMETYPEの作成
				String[] mimeType = new String[1];
				mimeType[0] = ClipDescription.MIMETYPE_TEXT_PLAIN;

				//クリップボードに格納するClipDataオブジェクトの作成
				ClipData cd = new ClipData(new ClipDescription("text_data", mimeType), item);

				//クリップボードにデータを格納
				ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
				cm.setPrimaryClip(cd);
			}
		});

        //貼り付けボタン
        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//システムのクリップボードを取得
				ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

				//クリップボードからClipDataを取得
				ClipData cd = cm.getPrimaryClip();

				//クリップデータからItemを取得
				if(cd != null){
					ClipData.Item item = cd.getItemAt(0);
					EditText et = (EditText)findViewById(R.id.editText2);
					et.setText(item.getText());
				}
			}
		});
    }
}