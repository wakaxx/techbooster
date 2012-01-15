package org.jpn.techbooster.Button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends Activity implements OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // ボタン1の登録
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        // ボタン2の登録
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// ボタン1が押された場合
		if (v.getId() == R.id.button1) {
			Toast.makeText(this, "ボタン1が押されました！", Toast.LENGTH_LONG).show();
		// ボタン2が押された場合
		} else if (v.getId() == R.id.button2) {
			Toast.makeText(this, "ボタン2が押されました！", Toast.LENGTH_LONG).show();
		}
	}
}