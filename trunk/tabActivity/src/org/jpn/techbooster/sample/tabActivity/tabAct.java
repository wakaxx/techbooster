/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.tabActivity;


import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class tabAct extends TabActivity  implements TabHost.TabContentFactory {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


		//TabActivityでは、getTabHostメソッドが使えます
		TabHost tabHost = getTabHost();

		//子となるタブの設定
		TabSpec firstTab = tabHost.newTabSpec("First");
		firstTab.setIndicator("firstTab");			//タブ上の文字列
		firstTab.setContent(R.id.first_content);	//表示するView
		tabHost.addTab(firstTab);


		//画像を使う場合
		TabSpec secondTab = tabHost.newTabSpec("Second");
		secondTab.setIndicator("secondTab", getResources().getDrawable(android.R.drawable.ic_menu_agenda));      // タブに表示する文字列と画像
		secondTab.setContent(R.id.second_content); //表示するView
		tabHost.addTab(secondTab);

		//タブコンテンツのファクトリーを使う場合
		TabSpec thirdTab = tabHost.newTabSpec("Third");
		thirdTab.setIndicator("thirdTab");		//タブ上の文字列
		thirdTab.setContent(this); 				//TabContentFactoryを設定、タブ選択時に表示するビューを生成
		tabHost.addTab(thirdTab);

		// 初期表示設定
		tabHost.setCurrentTabByTag("First");	//tabHost.setCurrentTab(0)でもOK
    }

	public View createTabContent(String tag) {
        TextView textView = new TextView(this);
        textView.setText("Content for tab with tag " + tag);
        return textView;
	}
}