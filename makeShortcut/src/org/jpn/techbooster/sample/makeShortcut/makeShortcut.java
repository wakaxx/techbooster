package org.jpn.techbooster.sample.makeShortcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class makeShortcut extends Activity implements OnClickListener {
	Button button1, button2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button1 = (Button) findViewById(R.id.shortcut_btn1);
        button1.setOnClickListener(this);
        
        button2 = (Button) findViewById(R.id.shortcut_btn2);
        button2.setOnClickListener(this);
        
        // 受信したインテントからメッセージを取得
        Intent intent = getIntent();
        String msg = intent.getStringExtra("MESSAGE");

        // メッセージをToastで表示
        if (msg != null)
        	Toast.makeText(this, ""+msg, Toast.LENGTH_LONG).show();
    }
    
    // ショートカットインテントを設定したインテントを作る
    Intent makeIntent(String shortcutName, Intent shortcutIntent) {
    	Intent intent = new Intent();
    	
    	// ショートカットインテントを設定
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);

        // ショートカット名を設定
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        
        // アイコン設定
        Parcelable iconResource = Intent.ShortcutIconResource.fromContext(this, R.drawable.icon);
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);

        // アクションを設定
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    	
		return intent;
    }

	public void onClick(View v) {
		if (v.getId() == R.id.shortcut_btn1) {
			// ショートカットインテントを作成
            Intent shortcutIntent=new Intent(Intent.ACTION_VIEW);
            shortcutIntent.setClassName(this, makeShortcut.class.getName());

            // メッセージを設定
            shortcutIntent.putExtra("MESSAGE","THIS IS TEST MESSAGE!!!");
			
            // 送信
            sendBroadcast(makeIntent("shortcut1", shortcutIntent));
		} else if (v.getId() == R.id.shortcut_btn2) {
			// ショートカットインテントを作成
            Intent shortcutIntent=new Intent(Intent.ACTION_VIEW);
            shortcutIntent.setClassName(this, makeShortcut.class.getName());

            // メッセージを設定
            shortcutIntent.putExtra("MESSAGE","WE ARE TECHBOOSTER!!!");

            // インテント送信
            sendBroadcast(makeIntent("shortcut2", shortcutIntent));
		}
	}
}
