package org.jpn.techbooster.sample.nativesample2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main extends Activity {
	static {
        System.loadLibrary("native_sample");
   }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.sample);
        Bitmap subbmp = bmp.copy(Bitmap.Config.RGB_565, true);

        int width = subbmp.getWidth();
        int height = subbmp.getHeight();
        
        
        int pixels[] = new int[width * height];
        int cnt = 0;
        subbmp.getPixels(pixels, 0, width, 0, 0, width, height);
        
        nativeBinarization(pixels,subbmp.getWidth(),subbmp.getHeight());
        subbmp.setPixels(pixels, 0, width, 0, 0, width, height);
        LinearLayout llayout = (LinearLayout)findViewById(R.id.llayout);
        
        ImageView binarizeBmp = new ImageView(this);
        binarizeBmp.setImageBitmap(subbmp);
        ImageView normalBmp = new ImageView(this);
        normalBmp.setImageBitmap(bmp);
        
        llayout.addView(normalBmp);
        llayout.addView(binarizeBmp);
        
    }
    
    public native void nativeBinarization(int[] pixels, int x, int y);
}