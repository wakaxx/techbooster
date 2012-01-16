package org.jpn.techbooster.sample.fragmentmenusample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class FragmentMenu extends Activity implements OnClickListener {
	private static String LOGTAG = "FragmentMenuSample";
	static int FRAGMENT_MENU1 = 1;
	static int FRAGMENT_MENU2 = 2;
	Fragment mFragment1;
	Fragment mFragment2;
	CheckBox mCheckBox1;
	CheckBox mCheckBox2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_menu);

		//FragmentManagerを取得
		FragmentManager fm = getFragmentManager();
		
		//Fragmentの管理
		// add() -> commit() で追加
		// show() で表示
		// hide() で非表示
		FragmentTransaction ft = fm.beginTransaction();
		mFragment1 = fm.findFragmentByTag("f1");
		if (mFragment1 == null) {
			mFragment1 = new MenuFragment();
			ft.add(mFragment1, "f1");
		}
		mFragment2 = fm.findFragmentByTag("f2");
		if (mFragment2 == null) {
			mFragment2 = new Menu2Fragment();
			ft.add(mFragment2, "f2");
		}
		ft.commit();

		// Set OnClick Method
		mCheckBox1 = (CheckBox) findViewById(R.id.cBox_menu1);
		mCheckBox1.setOnClickListener(this);
		mCheckBox2 = (CheckBox) findViewById(R.id.cBox_menu2);
		mCheckBox2.setOnClickListener(this);

		updateFragmentVisibility();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		updateFragmentVisibility();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		menu.add(Menu.NONE, 11, Menu.NONE,"STATIC MENU");
		return super.onCreateOptionsMenu(menu);
	}
		
	@Override
	public void onClick(View arg0) {
		updateFragmentVisibility();
	}

	/* FragmentMenuの表示/非表示を管理する。 */
	void updateFragmentVisibility() {
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		if (mCheckBox1.isChecked())
			ft.show(mFragment1);
		else
			ft.hide(mFragment1);
		if (mCheckBox2.isChecked())
			ft.show(mFragment2);
		else
			ft.hide(mFragment2);
		ft.commit();
	}

	public static class MenuFragment extends Fragment {

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setHasOptionsMenu(true);
		}

		@Override
		public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
			/*
			 * add( int groupId, 
			 *  int itemId, 
			 *  int order, 
			 *  int titleRes //title string or resource identifier )
			 */
			menu.add(Menu.NONE, FRAGMENT_MENU1, Menu.NONE, "FragmentMenu 1a").setShowAsAction(
					MenuItem.SHOW_AS_ACTION_ALWAYS);
			menu.add(Menu.NONE, FRAGMENT_MENU2, Menu.NONE, "FragmentMenu 1b").setShowAsAction(
					MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			boolean ret = true;

			switch (item.getItemId()){
			case 1:
				Log.v(LOGTAG,"menu 1a is pushed");
				break;
			case 2 :
				Log.v(LOGTAG,"menu 1b is pushed");
				break;
			default:
				ret = super.onOptionsItemSelected(item);
				break;
			}

			return ret;
		}
	}

	public static class Menu2Fragment extends Fragment {

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setHasOptionsMenu(true);
		}

		@Override
		public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
			menu.add(Menu.NONE,12,Menu.NONE,"FragmentMenu 2").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
	}

}
