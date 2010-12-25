package org.jpn.techbooster.sample.asynctask;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.ImageView;

public class MonochromeTask extends AsyncTask<Bitmap, Integer, Bitmap> {
	private ImageView imageView_;
	
	public MonochromeTask(ImageView imageView) {
		super();
		imageView_ = imageView;
	}
		
	@Override
	protected Bitmap doInBackground(Bitmap... bitMap) {
		Bitmap outBitMap = bitMap[0].copy(Bitmap.Config.ARGB_8888, true); 
		
		int width = outBitMap.getWidth();
		int height = outBitMap.getHeight();

		int i, j;
		for (j = 0; j < height; j++) {
			for (i = 0; i < width; i++) {
				int pixelColor = outBitMap.getPixel(i, j);
				int y = (int) (0.299 * Color.red(pixelColor) +
						0.587 * Color.green(pixelColor) +
						0.114 * Color.blue(pixelColor));
				outBitMap.setPixel(i, j, Color.rgb(y, y, y));
				for (int n = 0; n < 500; n++){}
			}
		}
		
		return outBitMap;
	}
	
    @Override  
    protected void onPostExecute(Bitmap result) {
        imageView_.setImageBitmap(result);  
    }  
}
