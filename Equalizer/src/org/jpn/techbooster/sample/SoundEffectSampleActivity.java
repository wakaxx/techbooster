package org.jpn.techbooster.sample;

import org.jpn.techbooster.soundeeffectsample.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.util.Log;

public class SoundEffectSampleActivity extends Activity {
	private MediaPlayer mediaPlayer_;
	private Equalizer equalizer_;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        	
        	
        mediaPlayer_ = MediaPlayer.create(this, R.raw.music);
        equalizer_ = new Equalizer(0, mediaPlayer_.getAudioSessionId());
        equalizer_.setEnabled(true);
        short bands = equalizer_.getNumberOfBands();
        Log.d("EqualizerSample", "NumberOfBands: " + bands);

        short minEQLevel = equalizer_.getBandLevelRange()[0];
        short maxEQLevel = equalizer_.getBandLevelRange()[1];
        Log.d("EqualizerSample", "minEQLevel: " + String.valueOf(minEQLevel));            
        Log.d("EqualizerSample", "maxEQLevel: " + String.valueOf(maxEQLevel));            

        for (short i = 0; i < bands; i++) {
        	Log.d("EqualizerSample", i + String.valueOf(equalizer_.getCenterFreq(i) / 1000) + "Hz");
        	equalizer_.setBandLevel(i, (short)((minEQLevel + maxEQLevel) / 2));
        }
	    mediaPlayer_.start();
        Log.d("SoundEffectSampleActivity", String.valueOf(mediaPlayer_.getAudioSessionId()));
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	mediaPlayer_.stop();
    }
}