package org.jpn.techbooster.sample.gridlayoutsample;

import com.kobashin.sample14.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Test14SampleActivity extends Activity implements OnClickListener {
	Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btP, btE;
	TextView tv;
	int before;
	boolean cleanFlag = false;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
/*
		// set View
		bt0 = (Button) findViewById(R.id.button0);
		bt0.setOnClickListener(this);

		bt1 = (Button) findViewById(R.id.button1);
		bt1.setOnClickListener(this);

		bt2 = (Button) findViewById(R.id.button2);
		bt2.setOnClickListener(this);

		bt3 = (Button) findViewById(R.id.button3);
		bt3.setOnClickListener(this);

		bt4 = (Button) findViewById(R.id.button4);
		bt4.setOnClickListener(this);

		bt5 = (Button) findViewById(R.id.button5);
		bt5.setOnClickListener(this);

		bt6 = (Button) findViewById(R.id.button6);
		bt6.setOnClickListener(this);

		bt7 = (Button) findViewById(R.id.button7);
		bt7.setOnClickListener(this);

		bt8 = (Button) findViewById(R.id.button8);
		bt8.setOnClickListener(this);

		bt9 = (Button) findViewById(R.id.button9);
		bt9.setOnClickListener(this);

		btP = (Button) findViewById(R.id.buttonPlus);
		btP.setOnClickListener(this);

		btE = (Button) findViewById(R.id.buttonEqu);
		btE.setOnClickListener(this);

		tv = (TextView) findViewById(R.id.ansField);
		*/
	}

	@Override
	public void onClick(View v) {
		if(cleanFlag){ 
			tv.setText("");
			cleanFlag = false;
		}
		switch (v.getId()) {
		case R.id.button0:
			tv.setText(tv.getText() + "0");
			break;
		case R.id.button1:
			tv.setText(tv.getText() + "1");
			break;
		case R.id.button2:
			tv.setText(tv.getText() + "2");
			break;
		case R.id.button3:
			tv.setText(tv.getText() + "3");
			break;
		case R.id.button4:
			tv.setText(tv.getText() + "4");
			break;
		case R.id.button5:
			tv.setText(tv.getText() + "5");
			break;
		case R.id.button6:
			tv.setText(tv.getText() + "6");
			break;
		case R.id.button7:
			tv.setText(tv.getText() + "7");
			break;
		case R.id.button8:
			tv.setText(tv.getText() + "8");
			break;
		case R.id.button9:
			tv.setText(tv.getText() + "9");
			break;
		case R.id.buttonPlus:
			String temp = tv.getText().toString();
			before = Integer.parseInt(temp);
			cleanFlag = true;
			break;
		case R.id.buttonEqu:
			tv.setText(Integer.toString(before
					+ Integer.parseInt(tv.getText().toString())));
			before = 0;
			cleanFlag = true;
			break;
		default:
		}

	}
}