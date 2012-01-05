package org.japan.techbooster.sample.Analytics;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AnalyzedActivity extends Activity {
	
	GoogleAnalyticsTracker tracker;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //トラッカーのインスタンス生成
        tracker = GoogleAnalyticsTracker.getInstance();        
        tracker.start("UA-24434459-1",this);
//        tracker.start("UA-24434459-1", 10,this);
		tracker.trackPageView("/AnalyzedActivity");
        
        Button umi = (Button)findViewById(R.id.umi);
        Button majo = (Button)findViewById(R.id.majo);
        Button gedo = (Button)findViewById(R.id.gedo);

        umi.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
		    	Intent intent = new Intent(AnalyzedActivity.this, SecondActivity.class);
				tracker.trackEvent("Button", " Clicked", "umi", 1);
				intent.putExtra("num", 1);
				startActivity(intent);
			}
        });
        
        majo.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
		    	Intent intent = new Intent(AnalyzedActivity.this, SecondActivity.class);
				tracker.trackEvent("Button", "Clicked", "majo", 2);
				intent.putExtra("num", 2);
				startActivity(intent);
			}
        });
        
        gedo.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
		    	Intent intent = new Intent(AnalyzedActivity.this, SecondActivity.class);
				tracker.trackEvent("Button", "Clicked", "gedo", 2);
				intent.putExtra("num", 3);
				startActivity(intent);
			}
        });
    }
    
    @Override
    protected void onStart() {
      super.onStart();
      // 追跡の開始

    }
    
    @Override
    protected void onPause() {
      super.onPause();
      // 追跡の結果の送信
      tracker.dispatch();
    }
    
    @Override
    protected void onDestroy() {
      super.onDestroy();

      // これ以上必要のない追跡を停止する
      tracker.stop();
    }
}