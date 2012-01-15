package org.jpn.techbooster;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Gallery;

public class GalleryActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
    }
}