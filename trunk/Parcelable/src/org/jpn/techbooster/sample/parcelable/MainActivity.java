package org.jpn.techbooster.sample.parcelable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	private SampleParcelable mSampleParcelable;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mSampleParcelable = new SampleParcelable(7, "hoge");  
    }
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d("Parcelable", "onSaveInstanceState");
		outState.putParcelable("parcelable", mSampleParcelable);  
	}

    @Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		mSampleParcelable = savedInstanceState.getParcelable("parcelable");  
		Log.d("Parcelable", "onRestoreInstanceState " + mSampleParcelable.mData +  mSampleParcelable.mString);
	}
}