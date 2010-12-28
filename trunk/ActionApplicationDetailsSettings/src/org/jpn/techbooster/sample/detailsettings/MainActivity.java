package org.jpn.techbooster.sample.detailsettings;

import org.jpn.techbooster.sample.detailsettings.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button buttonDetails = (Button)findViewById(R.id.ButtonDetailsSettings);
        Button buttonAll = (Button)findViewById(R.id.ButtonAllApplicationsSettings);
        
        buttonDetails.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
		        Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:"+getPackageName()));
		        startActivity(intent);				
			}
		});
        
        buttonAll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
		        Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
		        startActivity(intent);
			}
		});
	}
}
