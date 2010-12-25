package org.jpn.techbooster.sample.downloadmanager;

import org.jpn.techbooster.sample.downloadmanager.R;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DownloadManagerActivity extends Activity implements OnClickListener {	
	private DownloadManager downLoadManager_;
	private Button buttonDownLoadStart_;
	private Button buttonCheckStatus_;
	private long id_;
	
	public class DownloadReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();
		}
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        buttonDownLoadStart_ = (Button)findViewById(R.id.ButtonDownLoadStart);
        buttonDownLoadStart_.setOnClickListener(this);
        buttonCheckStatus_ = (Button)findViewById(R.id.ButtonCheckStatus);
        buttonCheckStatus_.setOnClickListener(this);
        
        downLoadManager_ = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
    }
    
    private void downLoad() {
    	Uri.Builder uriBuilder = new Uri.Builder();
    	uriBuilder.scheme("http");
    	uriBuilder.authority("cross-bridge.jp");
    	uriBuilder.path("/app/img/Android/Icon_SignalCat_52.png");
    	
    	Request request = new Request(uriBuilder.build());
    	request.setTitle("TechBooster");
    	request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, "abc.png");
    	request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
    	request.setMimeType("image/png");
    
    	id_ = downLoadManager_.enqueue(request);
    }
    
    private void checkStatus() {
        Query query = new Query();
        query.setFilterById(id_);
        Cursor cursor = downLoadManager_.query(query);
        int id = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
        cursor.moveToFirst();
        Log.d("DownloadManagerSample", cursor.getString(id));
    }
    
	@Override
	public void onClick(View v) {
		if (v == buttonDownLoadStart_) {
	        downLoad();			
		} else if (v == buttonCheckStatus_) {
			checkStatus();
		}
	}
}