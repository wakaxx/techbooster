package org.jpn.techbooster.sample.ActionBarTabSample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

public class ActionBarTabSampleActivity extends Activity implements TabListener{
	private Fragment _mFragment;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // AcionBarを取得
        final ActionBar bar = getActionBar();
        // NvigationModeをNAVIGATION_MODE_TABSに設定
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // タブの追加
        bar.addTab(bar.newTab().setText("Tab1").setTabListener(this));
        bar.addTab(bar.newTab().setText("Tab2").setTabListener(this));
        bar.addTab(bar.newTab().setText("Tab3").setTabListener(this));
    }

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// Fragmentの生成
		_mFragment = ActionBarTabFragment.newInstance(tab.getText().toString());
		
		// Fragmentを配置
		ft.add(R.id.frameLayout1, _mFragment, null);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// Fragmentの削除
		ft.remove(_mFragment);
	}
	
	private static class ActionBarTabFragment extends Fragment {
		private static String _tagName;
		
		static ActionBarTabFragment newInstance(String tagName){
			_tagName = tagName;
			ActionBarTabFragment f = new ActionBarTabFragment();
			return f;
		}
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			TextView tv = new TextView(getActivity().getApplicationContext());
			tv.setText(_tagName + "Fragment");
			if(_tagName.equals("Tab2")){
				//tv.setTextColor(R.color.red);
			}
			if(_tagName.equals("Tab3")){
				//tv.setTextColor(R.color.blue);
			}
			getActivity().setContentView(tv);
		}
	}
}