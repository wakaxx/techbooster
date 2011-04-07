package org.jpn.techboostser.sample.scalegesturedetector;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GestureDetectView view = new GestureDetectView(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        
        setContentView(view);
    }
}