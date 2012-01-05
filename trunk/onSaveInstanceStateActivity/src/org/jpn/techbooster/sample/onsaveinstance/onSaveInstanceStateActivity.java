package org.jpn.techbooster.sample.onsaveinstance;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class onSaveInstanceStateActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    	Log.d("Lifecycle","onCreate()");
    }

    @Override
    protected void onPause() {
    	// TODO 自動生成されたメソッド・スタブ
    	super.onPause();

    	Log.d("Lifecycle","onPause()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	Log.d("Lifecycle","onSaveInstanceState()");

    	//インスタンスの保存
    	EditText et = (EditText)findViewById(R.id.editText1);
    	Editable editable = et.getText();

    	outState.putString("EDITTEXT_KEY", editable.toString() );
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	Log.d("Lifecycle","onRestoreInstanceState()");

    	//インスタンスの復帰
    	String str = savedInstanceState.getString("EDITTEXT_KEY");
    	TextView tv = (TextView)findViewById(R.id.textView1);

    	tv.setText("onRestoreInstanceState:" + str);
    }

}