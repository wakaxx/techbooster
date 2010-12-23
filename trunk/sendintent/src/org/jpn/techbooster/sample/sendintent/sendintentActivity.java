/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.sendintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class sendintentActivity extends Activity implements OnClickListener {

	static final int MY_INTENT_BROWSER = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        //buttonを取得
        Button btn = (Button)findViewById(R.id.Button01);
        btn.setOnClickListener(this);
    }

	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
    	Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://techbooster.jpn.org/"));

    	startActivityForResult(intent,MY_INTENT_BROWSER);
	}

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

    	//返り値の取得
	    if (requestCode == MY_INTENT_BROWSER) {

	        if (resultCode == RESULT_OK) {
	        	// Success
	        } else if (resultCode == RESULT_CANCELED) {
	            // Handle cancel
	        }
	    }
    }

}