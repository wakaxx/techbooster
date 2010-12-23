/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.surfaceView;

import android.app.Activity;
import android.os.Bundle;

public class surfaceViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new sampleSurfaceView(this));
    }
}