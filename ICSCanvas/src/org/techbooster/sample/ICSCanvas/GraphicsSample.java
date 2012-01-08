package org.techbooster.sample.ICSCanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

public class GraphicsSample extends View {

	public GraphicsSample(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void onDraw(Canvas canvas) {
    	Log.d("test", ""+ canvas.getMaximumBitmapHeight());
    	Log.d("test", ""+ canvas.getMaximumBitmapWidth());
    	
    	Paint paint = new Paint();
    	paint.setColor(Color.RED);
    	paint.setHinting(Paint.HINTING_ON);
    	
    	canvas.drawCircle(100, 100, 100, paint);
    	Log.d("test", ""+ paint.getHinting());
    	
    	paint.setColor(Color.BLUE);
    	RectF r = new RectF(250, 20, 300, 70);
    	canvas.drawRect(r, paint);
    	String shortString = r.toShortString();
    	Log.d("test", "r.shortString = " + shortString);	
    }
}
