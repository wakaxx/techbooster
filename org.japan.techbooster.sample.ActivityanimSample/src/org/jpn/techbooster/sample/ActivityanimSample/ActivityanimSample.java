package org.jpn.techbooster.sample.ActivityanimSample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class ActivityanimSample extends Activity {
    /** Called when the activity is first created. */
	private float actDownX;
	private float actDownY;
	private float actUpX;
	private float actUpY;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event){
    	//左方向に指をスライドさせた場合に画面遷移
    	switch(event.getAction()){
    	case MotionEvent.ACTION_DOWN:
    		actDownX = event.getX();
    		actDownY = event.getY();
    		break;
    	case MotionEvent.ACTION_MOVE:
    		break;
    	case MotionEvent.ACTION_UP:
    		actUpX = event.getX();
    		actUpY = event.getY();
    		if(actDownX - actUpX > 100){
	    		Intent intent = new Intent(ActivityanimSample.this, AcitivityanimSample2.class);
	    		startActivity(intent);
    		}
    		break;
    	}
		return false;
    	
    }
}