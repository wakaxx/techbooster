package org.jpn.techbooster.sample.customprogressbar;

import org.jpn.techbooster.sample.customprogressbar.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class CustomProgressBarActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.ProgressBarPic);
        progressBar.setMax(100);
        progressBar.setProgress(60);
        
    }
}