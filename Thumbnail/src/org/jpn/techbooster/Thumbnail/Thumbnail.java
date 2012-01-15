package org.jpn.techbooster.Thumbnail;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.Log;
import android.widget.ImageView;

public class Thumbnail extends Activity {
	// ThumbnailUtilsインスタンス作成
	ThumbnailUtils tu = new ThumbnailUtils();
	// サムネイル用Bitmap
	Bitmap bitmap1=null, bitmap2;
	// サムネイル用Bitmap
	ImageView iv, iv2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		List<RunningTaskInfo> taskInfoList = am.getRunningTasks(99);
		bitmap1 = taskInfoList.get(2).thumbnail;
		if (bitmap1!=null) {
			Log.i("xxx","is not null");
		} else {
			Log.i("xxx","is null");
		}
		
		if(taskInfoList != null){
		    for (RunningTaskInfo task : taskInfoList){
		 
		        //エラー情報
		        Log.d("ActivityManager","task.id           :"+task.id);
		        Log.d("ActivityManager","task.description  :"+task.description);
		        Log.d("ActivityManager","task.numActivities:"+task.numActivities);
		        Log.d("ActivityManager","task.numRunning   :"+task.numRunning);
		    }
		}
		
		// 表示用ImageView
		iv = (ImageView) findViewById(R.id.imageView1);
		iv2 = (ImageView) findViewById(R.id.imageView2);
		
		// sample.3gpのサムネイルを作成して表示する
//		bitmap1 = tu.createVideoThumbnail("/sdcard/sample.3gp", Thumbnails.MINI_KIND);
		iv.setImageBitmap(bitmap1);
		
		// sample.3gpのサムネイルを64x64にリサイズして表示する
//		bitmap2 = tu.extractThumbnail(bitmap1, 64, 64);
//		iv2.setImageBitmap(bitmap2);
	}
}
