package org.jpn.techbooster.sample.customlistview;

import android.graphics.Bitmap;

public class CustomData {
	private String textData_;
	private Bitmap imageData_;
	
	public void setTextData(String text) {
		textData_ = text;
	}
	
	public String getTextData() {
		return textData_;
	}
	
	public void setImagaData(Bitmap image) {
		imageData_ = image;
	}
	
	public Bitmap getImageData() {
		return imageData_;
	}
}
