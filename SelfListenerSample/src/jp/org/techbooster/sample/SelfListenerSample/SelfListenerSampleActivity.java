package jp.org.techbooster.sample.SelfListenerSample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelfListenerSampleActivity extends Activity implements OnClickListener, SampleListenerInterface{
    
    private SampleNotify sn = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText et = (EditText) findViewById(R.id.editText1);
        // 通知用クラスのインスタンス化
        sn = new SampleNotify(et);
        // 通知用クラスに通知先のインスタンスを付加
        sn.setListener(this);
        
        Button btn = (Button) findViewById(R.id.button1);
        
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 通知用クラスのメソッドを実行
        sn.checkText();
    }

    @Override
    public void noInputText() {
        Toast.makeText(this, "テキスト空です", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void inputText() {
        Toast.makeText(this, "テキスト入力されてます", Toast.LENGTH_SHORT).show();
    }
}