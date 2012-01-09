package org.jpn.techbooster.GetImageFromCameraSample;

import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

public class GetImageFromCameraSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Intentの取得
		Intent cameraIntent = getIntent();

		//画像のUri取得
		Uri uri;
		if (Intent.ACTION_SEND.equals(cameraIntent.getAction())) {
			uri = cameraIntent.getParcelableExtra(Intent.EXTRA_STREAM);
		}else{
			return;
		}

		//Uriから画像を取得
		Bitmap cameraImage = null;
		try {
			cameraImage = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//ImageViewに取得した画像をセット
		ImageView im = (ImageView)findViewById(R.id.imageView1);
		im.setImageBitmap(cameraImage);
    }
}