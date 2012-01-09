package net.sample.techbooster.customviewsample;

import android.app.Activity;
import android.os.Bundle;

public class SubActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);        
    }
}