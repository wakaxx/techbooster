/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.viewFlipperActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class viewFlipperActivity extends Activity implements OnClickListener{

	private ViewFlipper viewFlipper;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);

        Button prevButton = (Button) findViewById(R.id.prevButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);

        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        viewFlipper.setAutoStart(true);		//自動でスライドショーを開始
        viewFlipper.setFlipInterval(1000);	//更新間隔(ms単位)
    }

	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		switch(v.getId()){

		case R.id.prevButton:
			viewFlipper.showPrevious();
			break;

		case R.id.nextButton:
			viewFlipper.showNext();
			break;

		default:
				break;
		}

	}
}