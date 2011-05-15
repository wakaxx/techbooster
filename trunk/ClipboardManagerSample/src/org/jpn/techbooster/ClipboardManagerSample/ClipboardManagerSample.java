package org.jpn.techbooster.ClipboardManagerSample;

import android.app.Activity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ClipboardManagerSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //コピーボタン実装
        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//EditTextから文字を取得
				EditText et = (EditText)findViewById(R.id.editText1);
				CharSequence cs = et.getText();

				//ClipboardManagerに値をセット
				ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
				cm.setText(cs);
			}
		});

        //貼り付けボタン実装
        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//ClipboardManagerから文字を取得
				ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
				CharSequence cs = cm.getText();

				//EditTextに文字をコピー
				EditText et = (EditText)findViewById(R.id.editText2);
				et.setText(cs);
			}
		});
    }
}