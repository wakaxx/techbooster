package org.techbooster.sample.ICSCanvas;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;

public class ICSCanvasSampleActivity extends Activity {
    Canvas canvas;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsSample(this));
    }

}