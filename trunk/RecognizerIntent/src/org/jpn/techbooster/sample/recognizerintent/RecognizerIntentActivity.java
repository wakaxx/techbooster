package org.jpn.techbooster.sample.recognizerintent;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RecognizerIntentActivity extends Activity {
	// onActivityResultが呼び出された時に照合できるように任意のint型の値を定義しておく
	static final private int REQUEST_CODE = 0;
	static final private String TAG = "RecognizerIntentActivity";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button)findViewById(R.id.ButtonStart);
        button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
                try {
                	Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
//                	Intent intent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
                    
                	intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    		RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                	
                	// 任意のメッセージを表示させることも可能(ACTION_WEB_SEARCHの時は無効)
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                            "Please Speech");
                    startActivityForResult(intent, REQUEST_CODE);
                } catch (ActivityNotFoundException e) {
                	// 端末が音声認識に対応していない場合
                	Log.e(TAG, "Error");
                }
			}
		});
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// requestCodeを確認して、自分が発行したIntentの結果であれば処理を行う
        if ((REQUEST_CODE == requestCode) && (RESULT_OK == resultCode)) {
            // 結果はArrayListで返ってくる
            ArrayList<String> results =
                data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            
            // ArrayListで返ってきた結果を一纏めにする
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < results.size(); i++) {
            	stringBuffer.append(results.get(i));
            }
            
            // 結果を表示する
            Toast.makeText(this, stringBuffer.toString(), Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}