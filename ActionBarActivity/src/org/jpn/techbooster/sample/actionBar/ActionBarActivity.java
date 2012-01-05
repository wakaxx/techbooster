package org.jpn.techbooster.sample.actionBar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class ActionBarActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // The Action Bar is a window feature. The feature must be requested
        // before setting a content view. Normally this is set automatically
        // by your Activity's theme in your manifest. The provided system
        // theme Theme.WithActionBar enables this for you. Use it as you would
        // use Theme.NoTitleBar. You can add an Action Bar to your own themes
        // by adding the element <item name="android:windowActionBar">true</item>
        // to your style definition.

        //setContentViewより前にWindowにActionBar表示を設定
        getWindow().requestFeature(Window.FEATURE_ACTION_MODE_OVERLAY);
        //setTheme(android.R.style.Theme_Black_NoTitleBar);		//タイトルバー(アクションバー)なし
        //setTheme(android.R.style.Theme.WithActionBar);		//アクションバーあり
        setContentView(R.layout.main);
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // メニューの要素を追加
	    menu.add("Normal item");

	    // メニューの要素を追加して取得
	    MenuItem actionItem = menu.add("Action Button");

	    // SHOW_AS_ACTION_IF_ROOM:余裕があれば表示
	    actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

	    // アイコンを設定
	    actionItem.setIcon(android.R.drawable.ic_menu_share);

	    return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
	    return true;
	}
}