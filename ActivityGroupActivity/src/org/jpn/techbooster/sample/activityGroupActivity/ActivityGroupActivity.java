/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.activityGroupActivity;


import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class ActivityGroupActivity extends ActivityGroup {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Activityを呼び出す準備
        LocalActivityManager am = getLocalActivityManager();
        LinearLayout layout = (LinearLayout)findViewById(R.layout.activity_layout);

        //LocalActivityManager#startActivityはIntentを使う
		Intent intent = new Intent(this, Sample1Activity.class);
		Window window = am.startActivity("Sample1_UniqueString", intent);

		//Viewの取得
		View view = window.getDecorView();
		layout.addView(view);

		/* 2つめのActivity */
		Intent intent2 = new Intent(this, Sample2Activity.class);
		Window window2 = am.startActivity("Sample1_UniqueString", intent2);
		View view2 = window2.getDecorView();

		layout.addView(view2);
    }
}