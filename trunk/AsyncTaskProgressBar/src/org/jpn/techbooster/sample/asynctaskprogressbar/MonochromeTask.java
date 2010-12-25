package org.jpn.techbooster.sample.asynctaskprogressbar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.widget.ImageView;

public class MonochromeTask extends AsyncTask<Bitmap, Integer, Bitmap> {
	private ImageView imageView_;
	private ProgressDialog progressDialog_;
	private Activity uiActivity_;
	
	public MonochromeTask(Activity activity, ImageView imageView) {
		super();
		uiActivity_ = activity;
		imageView_ = imageView;
	}
	
	@Override
	protected void onPreExecute() {
	    progressDialog_ = new ProgressDialog(uiActivity_);
	    progressDialog_.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	    progressDialog_.setIndeterminate(false);
	    progressDialog_.show();
	}
	
	@Override
	protected Bitmap doInBackground(Bitmap... bitMap) {
		Bitmap outBitMap = bitMap[0].copy(Bitmap.Config.ARGB_8888, true); 
		
		int width = outBitMap.getWidth();
		int height = outBitMap.getHeight();
		int totalPixcel = width * height;
	    progressDialog_.setMax(totalPixcel);

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
			onProgressUpdate(i + j);
		}
		
		return outBitMap;
	}
	
	@Override
	protected void onProgressUpdate(Integer... progress) {
		progressDialog_.incrementProgressBy(progress[0]);
	}
	
    @Override  
    protected void onPostExecute(Bitmap result) {
    	progressDialog_.dismiss();
        imageView_.setImageBitmap(result);  
    }  
}
