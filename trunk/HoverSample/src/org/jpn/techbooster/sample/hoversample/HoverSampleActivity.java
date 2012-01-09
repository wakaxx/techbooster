package org.jpn.techbooster.sample.hoversample;

import com.kobashin.sample.hover.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.widget.ImageView;

public class HoverSampleActivity extends Activity implements OnHoverListener{
	private ImageView iv;
	static int ALPHA = 128;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        iv = (ImageView)findViewById(R.id.imageView1);
        iv.setAlpha(10);
        iv.setOnHoverListener(this);
    
    }

	@Override
	public boolean onHover(View v, MotionEvent event) {

		// ImageView以外で onHoverに入っても抜ける
		if(v.getId() != R.id.imageView1){
			return false;
		}
		
		switch(event.getAction()){
		case MotionEvent.ACTION_HOVER_ENTER:
			iv.setAlpha(ALPHA);
			break;
		case MotionEvent.ACTION_HOVER_MOVE:
			iv.setAlpha(addingAlpha());
			break;
		case MotionEvent.ACTION_HOVER_EXIT:
			iv.setAlpha(10);
			clearAlpha();
			break;
		}
		
		return true;
	}

	private int addingAlpha(){
		if(ALPHA == 255){
			return ALPHA;
		}
		return ++ALPHA;
	}
	
	private void clearAlpha(){
		ALPHA = 128;
	}
	
	
}