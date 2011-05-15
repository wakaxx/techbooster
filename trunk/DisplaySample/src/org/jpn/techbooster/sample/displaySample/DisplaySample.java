package org.jpn.techbooster.sample.displaySample;

import org.jpn.techbooster.sample.displaySample.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class DisplaySample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //画面の向きを縦の逆向きにする
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
        //画面の向きを横の逆向きにする
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
    }
}