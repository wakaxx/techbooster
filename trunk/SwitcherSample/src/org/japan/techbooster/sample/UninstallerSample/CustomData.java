package org.japan.techbooster.sample.UninstallerSample;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class CustomData {
    private Drawable imageData_;
    private String textData_;
 
    public void setImageData(Drawable image) {
        imageData_ = image;
    }
 
    public Drawable getImageData() {
        return imageData_;
    }
 
    public void setTextData(String text) {
        textData_ = text;
    }
 
    public String getTextData() {
        return textData_;
    }
}
