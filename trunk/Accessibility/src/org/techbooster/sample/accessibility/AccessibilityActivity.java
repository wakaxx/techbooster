package org.techbooster.sample.accessibility;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class AccessibilityActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView v = (ImageView) findViewById(R.id.imageView1);
        v.setContentDescription("Techbooster's mascot: mogutaso");
    }
}