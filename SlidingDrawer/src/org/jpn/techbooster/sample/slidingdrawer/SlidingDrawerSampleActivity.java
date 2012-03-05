package org.jpn.techbooster.sample.slidingdrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SlidingDrawer;

public class SlidingDrawerSampleActivity extends Activity implements OnClickListener{
	SlidingDrawer mDrawer;
	Button mButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mDrawer = (SlidingDrawer)findViewById(R.id.drawer);
        mButton = (Button)findViewById(R.id.closeButton);
        
        mButton.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		//mDrawer.close();
		mDrawer.animateClose();
	}
}