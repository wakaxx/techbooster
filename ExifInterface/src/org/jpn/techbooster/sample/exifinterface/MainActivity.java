package org.jpn.techbooster.sample.exifinterface;

import java.io.IOException;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private static final String TAG = "ExifInterfaceSample"; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String filePath = Environment.getExternalStorageDirectory().getPath() +
		"/sample.jpg";
    	ExifInterface exifInterface;

        try {
        	exifInterface = new ExifInterface(filePath);
		} catch (IOException e) {
			Log.e(TAG, "Error");
			return;
		}

        showExif(exifInterface);
        showThumbnail(exifInterface);
    }
    
    private void showExif(ExifInterface ei) {
		// API 5
		String exifString = getExifString(ei, ExifInterface.TAG_DATETIME) + "\n";
		exifString += getExifString(ei, ExifInterface.TAG_FLASH) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_GPS_LATITUDE) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_GPS_LONGITUDE) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_IMAGE_LENGTH) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_IMAGE_WIDTH) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_MAKE) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_MODEL) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_ORIENTATION) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_WHITE_BALANCE) + "\n";

		// API 8
		exifString += getExifString(ei, ExifInterface.TAG_FOCAL_LENGTH) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_GPS_DATESTAMP) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_GPS_PROCESSING_METHOD) + "\n";
		exifString +=getExifString(ei, ExifInterface.TAG_GPS_TIMESTAMP) + "\n";
		
		// API 9
		exifString +=getExifString(ei, ExifInterface.TAG_GPS_ALTITUDE) + "\n";
		
		// Honeycomb
//		exifString +=getExifString(ei, ExifInterface.TAG_APERTURE) + "\n";
//		exifString +=getExifString(ei, ExifInterface.TAG_EXPOSURE_TIME) + "\n";
//		exifString +=getExifString(ei, ExifInterface.TAG_ISO) + "\n";
		
		Log.d(TAG, exifString);
    }
    
    private String getExifString(ExifInterface ei,String tag) {
		// ファイルが存在しない場合にgetAttributeを呼び出したらNULLが返る
		// ファイルにEXIFが存在しない場合も同様にNULLが返る
		return tag + ": " + ei.getAttribute(tag);
    }
    
    private void showThumbnail(ExifInterface ei) {
		ImageView imageView = (ImageView)findViewById(R.id.ImageView);
		Bitmap thumb = getThumbnail(ei);
		if (null != thumb) {
			imageView.setImageBitmap(thumb);
		}
    }
    
    private Bitmap getThumbnail(ExifInterface ei) {
    	byte[] data = ei.getThumbnail();
    	
    	if (null == data) {
			Log.d(TAG, "No Thumbnail");
    		return null;
    	}
    	
    	return BitmapFactory.decodeByteArray(data, 0, data.length);
    }
}