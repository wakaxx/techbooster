package org.jpn.techbooster.sample.contextMenuActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.TextView;

public class ContextMenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView tv = (TextView)findViewById(R.id.textview);

        //Viewに追加する場合、registerForContextMenu(View);が必要
        registerForContextMenu(tv);

    }

    static final int CONTEXT_MENU1_ID = 0;
    static final int CONTEXT_MENU2_ID = 1;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {

    	super.onCreateContextMenu(menu, v, menuInfo);

    	//コンテキストメニューの設定
    	menu.setHeaderTitle("メニュータイトル");
    	//Menu.add(int groupId, int itemId, int order, CharSequence title)
    	menu.add(0, CONTEXT_MENU1_ID, 0, "メニュー1");
    	menu.add(0, CONTEXT_MENU2_ID, 0, "メニュー2");
    }

    public boolean onContextItemSelected(MenuItem item) {

    	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();

    	switch (item.getItemId()) {
    	case CONTEXT_MENU1_ID:
    		//TODO:メニュー押下時の操作
    		return true;
    	case CONTEXT_MENU2_ID:
    		//TODO:メニュー押下時の操作
    		return true;
    	default:
    		return super.onContextItemSelected(item);
    	}
    }
}