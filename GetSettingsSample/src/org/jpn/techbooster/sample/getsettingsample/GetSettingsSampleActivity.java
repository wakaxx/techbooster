package org.jpn.techbooster.sample.getsettingsample;

import com.kobashin.sample.settings.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GetSettingsSampleActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        // View Setting
        ((Button)findViewById(R.id.button1)).setOnClickListener(this);
    
    }

	@Override
	public void onClick(View v) {
		// ContentResolverの取得
		ContentResolver cr = getContentResolver();
		
		// Alarm音
		String alarm = Settings.System.getString(cr, Settings.System.ALARM_ALERT);
		
		// StayAwakeの設定
		String stay = Settings.System.getString(cr, Settings.System.STAY_ON_WHILE_PLUGGED_IN);
		
		// 12/24時間表示値
		String showHour = Settings.System.getString(cr, Settings.System.VIBRATE_ON);
		
		
		// textの作成
		StringBuilder sb = new StringBuilder();
		sb.append("ALARM_ALERT : ");
		sb.append(alarm);
		sb.append("\n\n");

		sb.append("STAY_ON_WHILE_PLUGGED_IN : ");
		sb.append(stay);
		sb.append("\n\n");
		
		sb.append("TIME_12_24 : ");
		sb.append(showHour);
		sb.append("\n\n");
		
		((TextView)findViewById(R.id.textView1)).setText(sb.toString());
		
		
		
		
	}
}