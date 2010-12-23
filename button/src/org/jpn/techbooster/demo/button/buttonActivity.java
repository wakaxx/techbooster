/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class buttonActivity extends Activity implements OnClickListener{
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
    	Toast.makeText(this, R.string.message , Toast.LENGTH_LONG).show();
	}
}