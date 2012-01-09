package org.jpn.techbooster.sample.tabsample;

import java.util.Calendar;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TabAct extends TabActivity implements TabHost.TabContentFactory {	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //TabHostクラスのインスタンス生成
        TabHost tabHost = getTabHost();
        
        // TabHostからTabSpecの生成
        TabSpec firstTab = tabHost.newTabSpec("First");
        // タブ部分に表示するテキストおよびアイコンのセット
        firstTab.setIndicator("firstTab", getResources().getDrawable(android.R.drawable.ic_menu_agenda));
        // タブ選択時に表示したいViewのセット
        firstTab.setContent(R.id.first_content);
        // タブをTabHostに追加
        tabHost.addTab(firstTab);
        
        TabSpec secondTab = tabHost.newTabSpec("Second");
        secondTab.setIndicator("secondTab", getResources().getDrawable(android.R.drawable.ic_media_next));
        secondTab.setContent(R.id.second_content);
        tabHost.addTab(secondTab);
        
        //３つ目のタブを生成
        TabSpec thirdTab = tabHost.newTabSpec("Third");
        thirdTab.setIndicator("thirdTab", getResources().getDrawable(android.R.drawable.ic_menu_add));
        thirdTab.setContent(this);
        tabHost.addTab(thirdTab);
        
        //最初にカーソルを当てたいタブを指定
        tabHost.setCurrentTabByTag("First");
        
    }

		@Override
		public View createTabContent(String tag) {
			Time time = new Time("Asia/Tokyo");
			time.setToNow();
			String date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日" + time.hour + "時" + time.minute + "分" + time.second + "秒";					
			TextView textView = new TextView(this);
			textView.setText(date);			
			return textView;
		}
	}