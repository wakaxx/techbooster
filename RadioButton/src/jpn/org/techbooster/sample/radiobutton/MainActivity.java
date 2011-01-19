package jpn.org.techbooster.sample.radiobutton;

import jpn.org.techbooster.sample.radiobutton.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	RadioGroup radioGroup_;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        radioGroup_ = (RadioGroup)findViewById(R.id.RadioGroup);
        radioGroup_.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int id) {
				if (-1 == id) {
					Toast.makeText(MainActivity.this,
							"クリアされました",
	                        Toast.LENGTH_SHORT).show();
				} else {
					Log.d("MainActivity", "");
					Toast.makeText(MainActivity.this,
	                        ((RadioButton)findViewById(id)).getText()
	                        	+ "が選択されました",
	                        Toast.LENGTH_SHORT).show();
				}
			}
        });
        
        Button button =(Button)findViewById(R.id.ButtonClear);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				radioGroup_.clearCheck();
			}
		});
        
        button = (Button)findViewById(R.id.ButtonCheck);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int checkedId = radioGroup_.getCheckedRadioButtonId();
				if (-1 != checkedId) {
					Toast.makeText(MainActivity.this,
							((RadioButton)findViewById(checkedId)).getText()
	                        	+ "が選択されています",
	                        Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(MainActivity.this,
							"何も選択されていません",
	                        Toast.LENGTH_SHORT).show();
				}	
			}
		});
    }
}