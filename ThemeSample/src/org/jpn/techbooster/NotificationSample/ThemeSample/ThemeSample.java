package org.jpn.techbooster.NotificationSample.ThemeSample;

import android.app.Activity;
import android.os.Bundle;

public class ThemeSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.MyStyle3); // コードからテーマを設定する。
        setContentView(R.layout.main);
    }
}