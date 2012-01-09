package org.jpn.techbooster.sample.splitactionbarsample;


import com.kobashin.sample.actionbar.R;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

public class ActionBarSampleActivity extends Activity implements TabListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // action bar を取得する
        final ActionBar mActionBar = getActionBar();
        
        // ActionBarにタブを表示する
        // このままでは表示されない
        mActionBar.addTab(mActionBar.newTab().setText("Tab 1").setTabListener(this));
        mActionBar.addTab(mActionBar.newTab().setText("Tab 2").setTabListener(this));
        mActionBar.addTab(mActionBar.newTab().setText("Tab 3").setTabListener(this));
        
        // ActionBarのNavigationModeを設定する
//        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        
        // ここまでで二段の状態で表示される
        
        
        // 上部のタイトル表示部分にタブを表示する
//        mActionBar.setDisplayShowHomeEnabled(false);
        // SHOW_TITLEのフラグを消すことで、タイトル表示を消す
//        mActionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
    }
    
    
    
    
    
    /**
     * Menu の Inflateをおこなう。
     *  getMenuInflaterからMenuInflaterを取得し、MenuInflater#inflate(Int res, Menu menu)
     *  を呼び出す
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.xml.actions, menu);
        return true;
    }





    
    /**
     * ActionBar.TabListenerのAbstractなMethod三つ
     */
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}