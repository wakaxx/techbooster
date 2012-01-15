package org.jpn.techbooster.sample.popupMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class popupMenu extends Activity implements OnClickListener {
	// ポップアップメニュー用ボタン
	Button PopupButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ポップアップメニュー用ボタンにクリック処理を割り当てる
		PopupButton = (Button) findViewById(R.id.PopupButton);
		PopupButton.setOnClickListener(this);

	}

	// ポップアップメニュー用ボタンのクリック処理
	@Override
	public void onClick(View button) {
		
		// PopupMenuのインスタンスを作成
		PopupMenu popup = new PopupMenu(this, button);

		// popup.xmlで設定したメニュー項目をポップアップメニューに割り当てる
		popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

		// ポップアップメニューを表示
		popup.show();

		// ポップアップメニューのメニュー項目のクリック処理
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				// 押されたメニュー項目名をToastで表示
				Toast.makeText(popupMenu.this, "Clicked : " + item.getTitle(),	Toast.LENGTH_SHORT).show();
				return true;
			}
		});
	}
}