package org.jpn.techbooster.sample.asynctaskprogressbar;

import org.jpn.techbooster.sample.asynctaskprogressbar.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class AsyncTaskProgressBarActivity extends Activity {
	private ImageView imageView_;	
    private Bitmap image_;
    private Button countButton_;
	private MonochromeTask task_;
	private Integer count = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // イメージの準備
        image_ = BitmapFactory.decodeResource(getResources(), R.drawable.tb);

        // 変換前のイメージを表示
        imageView_ = (ImageView)findViewById(R.id.ImageView);
        imageView_.setImageBitmap(image_);
        
        // タスクの生成
        task_ = new MonochromeTask(this, imageView_);
        
        Button startButton = (Button)findViewById(R.id.StartButton);
        startButton.setOnClickListener(new OnClickListener() {    
			@Override
			public void onClick(View view) {
				((Button)view).setEnabled(false);
				// 非同期処理を開始する
		        task_.execute(image_);
			}
        });
                
        countButton_ =  (Button)findViewById(R.id.CountButton);
        countButton_.setOnClickListener(new OnClickListener() {    
			@Override
			public void onClick(View view) {
				count++;
				((Button)view).setText(count.toString());
			}
        });
    }
}