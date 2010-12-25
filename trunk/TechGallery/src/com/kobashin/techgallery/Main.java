package com.kobashin.techgallery;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class Main extends Activity implements AdapterView.OnItemSelectedListener{
	ImageView fullView;

	protected Integer[] mImageIds = {
    		R.drawable.icon1,
    		R.drawable.icon2,
    		R.drawable.icon3,
    		R.drawable.icon4,
    		R.drawable.icon5
    	};
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Gallery gallery = (Gallery)findViewById(R.id.Gallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemSelectedListener(this);
        
        fullView = (ImageView)findViewById(R.id.ImageView_big);
    }
    
    @Override
    public void onItemSelected(AdapterView parent, View v, int position, long id){
    	fullView.setImageResource(mImageIds[position]);
    }
    
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
	}

    
    
    class ImageAdapter extends BaseAdapter{
    	int BackResId;
    	
    	private Context mContext;

		public ImageAdapter(Context cnt) {
			mContext = cnt;
            TypedArray a = obtainStyledAttributes(R.styleable.GalleryBackImage);
            BackResId = a.getResourceId(
                    R.styleable.GalleryBackImage_android_galleryItemBackground, 0);
            a.recycle();

		}

		@Override
		public int getCount() {
			return mImageIds.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView galleryView = new ImageView(mContext);
			
			galleryView.setImageResource(mImageIds[position]);
			galleryView.setScaleType(ImageView.ScaleType.FIT_CENTER);
			galleryView.setLayoutParams(new Gallery.LayoutParams(200, 60));
			
			galleryView.setBackgroundResource(BackResId);
			
			return galleryView;
		}
    	
    }
}
