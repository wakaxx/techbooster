/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.viewFlipperAnimationActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class viewFlipperAnimationActivity extends Activity implements OnClickListener{

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

       // viewFlipper.setAutoStart(true);		//自動でスライドショーを開始
       // viewFlipper.setFlipInterval(1000);	//更新間隔(ms単位)
    }

	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		switch(v.getId()){

		case R.id.prevButton:
			//XMLでも設定可能です
			//viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
			viewFlipper.showPrevious();
			break;

		case R.id.nextButton:

			//XMLでも設定可能です
			//viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
			viewFlipper.showNext();
			break;

		default:
				break;
		}

	}
}