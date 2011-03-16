package org.jpn.techooster.sample;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        File file = Environment.getExternalStorageDirectory();
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        BitmapRegionDecoder regionDecoder;
		try {
			regionDecoder = BitmapRegionDecoder.newInstance(file.toString() + "/sample.png",
																				false);
	        Rect rect = new Rect(0, 0, 150, 150);
	        Bitmap bitmap = regionDecoder.decodeRegion(rect, null);
	        imageView.setImageBitmap(bitmap);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}