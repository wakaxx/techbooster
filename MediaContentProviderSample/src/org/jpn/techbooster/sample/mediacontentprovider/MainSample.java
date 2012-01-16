package org.jpn.techbooster.sample.mediacontentprovider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.tcbsample.sample.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainSample extends Activity {
	GridView mGrid;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Cursor cursor = managedQuery(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null,
				null);

		cursor.moveToFirst();

		int fieldIndex;
		Long id;
		int cnt = 0, VolMax = 0;
		HashMap<Integer, Uri> uriMap = new HashMap<Integer, Uri>();

		do {
			fieldIndex = cursor.getColumnIndex(MediaStore.Images.Media._ID);
			id = cursor.getLong(fieldIndex);

			Uri bmpUri = ContentUris.withAppendedId(
					MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
			uriMap.put(cnt, bmpUri);
			cnt++;
		} while (cursor.moveToNext());

		/**/
		VolMax = --cnt;
		cnt = 0;

		/* Setting GridView */
		mGrid = (GridView) findViewById(R.id.myGrid);
		mGrid.setAdapter(new myAdapter(getContentResolver(), uriMap, VolMax));
	}

	public class myAdapter extends BaseAdapter {
		private ContentResolver cr;
		private HashMap<Integer, Uri> hm;
		private int MAX;
		private Bitmap tmpBmp;
		ImageView imageView;

		
		public myAdapter(ContentResolver _cr, HashMap<Integer, Uri> _hm, int max) {
			cr = _cr;
			hm = _hm;
			 //MAX = max;
			MAX = 30;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				imageView = new ImageView(MainSample.this);
				imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
			} else {
				imageView = (ImageView) convertView;
			}

			try {
				tmpBmp = MediaStore.Images.Media
						.getBitmap(cr, hm.get(position+100));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			imageView.setImageBitmap(tmpBmp);

			return imageView;
		}

		public final int getCount() {
			return MAX;
		}

		public final Object getItem(int position) {
			return position;
		}

		public final long getItemId(int position) {
			return position;
		}
	}
}