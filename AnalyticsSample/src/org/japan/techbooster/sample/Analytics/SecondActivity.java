package org.japan.techbooster.sample.Analytics;

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	GoogleAnalyticsTracker tracker;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        int num = getIntent().getExtras().getInt("num");
        
        TextView tv = (TextView)findViewById(R.id.textView);
        
        tracker = GoogleAnalyticsTracker.getInstance();   
        tracker.start("UA-24434459-1",5,this);
        
        //セッション
//        tracker.setCustomVar(2, "SecondActivity", "During Visit",3);
        //ページビュー
        tracker.trackPageView("/SecondAcivity");

        if(num == 1){
            tv.setText("海が荒ぶる");
        }else if(num == 2){
            tv.setText("魔法少女の特急便");
        }else{
            tv.setText("ゲド電気");
        }
    }
    
    @Override
    protected void onStart() {
      super.onStart();
    }
    
    @Override
    protected void onPause() {
      super.onPause();

      tracker.dispatch();
    }
    
    @Override
    protected void onDestroy() {
      super.onDestroy();
      // これ以上必要のない追跡を停止する
      tracker.stop();
    }
}
