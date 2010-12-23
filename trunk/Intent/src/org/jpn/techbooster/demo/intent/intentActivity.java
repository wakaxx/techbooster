/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class intentActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //buttonを取得
        Button btn = (Button)findViewById(R.id.Button01);
        btn.setOnClickListener(this);
    }

    //インターフェイスを実装 implements OnClickListener
    public void onClick(View v) {
    	// TODO 自動生成されたメソッド・スタブ

    	Intent intent=new Intent();
    	intent.setClassName("org.jpn.techbooster.demo.intent","org.jpn.techbooster.demo.intent.subActivity");
    	intent.putExtra("org.jpn.techbooster.demo.intent.testString", "!TEST STRING!");

    	startActivity(intent);

	}
}
