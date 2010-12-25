package org.jpn.techbooster.sample.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class ProgressBarActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        ProgressBar progressBar1 = (ProgressBar)findViewById(R.id.ProgressBarHorizontal1);
        
        // 水平プログレスバーの最大値を設定
        progressBar1.setMax(100);
        // 水平プログレスバーの値を設定
        progressBar1.setProgress(20);
        // 水平プログレスバーのセカンダリ値を設定
        progressBar1.setSecondaryProgress(60);
 
        ProgressBar progressBar2 = (ProgressBar)findViewById(R.id.ProgressBarHorizontal2);
        
        // 水平プログレスバーの最大値を設定
        progressBar2.setMax(200);
        // 水平プログレスバーの値を設定
        progressBar2.setProgress(150);
        // 水平プログレスバーのセカンダリ値を設定
        progressBar2.setSecondaryProgress(100);
    }
}