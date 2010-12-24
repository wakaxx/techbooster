package org.jpn.techbooster.sample;

import org.jpn.techbooster.soundpoolsample.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SoundPoolSampleActivity extends Activity {
    SoundPool soundPool_;
    int soundId_;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button playButton = (Button)findViewById(R.id.PlayButton);
        playButton.setOnClickListener(new OnClickListener() {
        	@Override
			public void onClick(View view) {
			       soundPool_.play(soundId_, 1.0F, 1.0F, 0, 0, 1.0F);
			}
		});
    }
    
   @Override
   protected void onResume() {
	   super.onResume();
	   
       soundPool_ = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
       
       // 2.2未満の場合はsetOnLoadCompleteListenerが使えないのでコメントアウトする必要があります
       soundPool_.setOnLoadCompleteListener(new OnLoadCompleteListener() {
    	   @Override
    	   public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
    		   if (0 == status) {
    			   Toast.makeText(getApplicationContext(), "LoadComplete", Toast.LENGTH_LONG).show();
    		   }
    	   }
       });
       
       soundId_ = soundPool_.load(this, R.raw.sound, 1);
   }
   
   @Override
   protected void onPause () {
	   super.onPause();
	   
	   soundPool_.release();
	   soundPool_ = null;
   }
}