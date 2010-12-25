package com.kobashin.applicationclasstest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Sub extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);
    	
        TextView tView = new TextView(this);

        /* getApplication()で自己アプリケーションクラスのインスタンスを拾う */
        TestApplication ta = (TestApplication)this.getApplication();

        Bitmap bmp_sub = ta.getObj();
        
        LinearLayout lLayout = (LinearLayout)findViewById(R.id.LinearLayout01);
        ImageView iView = (ImageView)findViewById(R.id.ImageView01);
        
        iView.setImageBitmap(bmp_sub);
        
    }
}