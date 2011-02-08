package org.jpn.techbooster.sample.mediametadataretriever;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private final static String TAG = "MediaMetadataRetriever";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String filePath = Environment.getExternalStorageDirectory().getPath() +
		"/sample.mp3";
        
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(filePath);

        Log.d(TAG, "METADATA_KEY_ALBUM: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
        Log.d(TAG, "METADATA_KEY_ALBUMARTIST: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST));
        Log.d(TAG, "METADATA_KEY_ARTIST: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
        Log.d(TAG, "METADATA_KEY_AUTHOR: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_AUTHOR));
        Log.d(TAG, "METADATA_KEY_COMPILATION: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER));
        Log.d(TAG, "METADATA_KEY_COMPILATION: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_COMPILATION));
        Log.d(TAG, "METADATA_KEY_DATE: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DATE));
        Log.d(TAG, "METADATA_KEY_DISC_NUMBER: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER));
        Log.d(TAG, "METADATA_KEY_DURATION: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
        Log.d(TAG, "METADATA_KEY_GENRE: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_GENRE));
        Log.d(TAG, "METADATA_KEY_MIMETYPE: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE));
        Log.d(TAG, "METADATA_KEY_NUM_TRACKS: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_NUM_TRACKS));
        Log.d(TAG, "METADATA_KEY_TITLE: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        Log.d(TAG, "METADATA_KEY_WRITER: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_WRITER));
        Log.d(TAG, "METADATA_KEY_YEAR: " + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR));
    
		ImageView imageView = (ImageView)findViewById(R.id.ImageView);
		byte[] data = mmr.getEmbeddedPicture();
		
		// 画像が無ければnullになる
		if (null != data) {
			imageView.setImageBitmap(BitmapFactory.decodeByteArray(data, 0, data.length));
		}
    }
}