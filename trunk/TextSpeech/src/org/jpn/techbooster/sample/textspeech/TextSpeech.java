package org.jpn.techbooster.sample.textspeech;

import java.util.Locale;
import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextSpeech extends Activity
								implements View.OnClickListener, TextToSpeech.OnInitListener {
	final private Float SPEECH_SLOW = 0.5f;
	final private Float SPEECH_NORMAL = 1.0f;
	final private Float SPEECH_FAST = 1.5f;
	final private Float PITCH_LOW = 0.5f;
	final private Float PITCH_NORMAL = 1.0f;
	final private Float PITCH_HIGH = 1.5f;
	private TextToSpeech	tts;
	private Button buttonSpeech;
	private Button buttonSlow;
	private Button buttonNormal;
	private Button buttonFast;
	private Button buttonLowPitch;
	private Button buttonNormalPitch;
	private Button buttonHighPitch;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        buttonSpeech = (Button)findViewById(R.id.ButtonSpeech);
        buttonSpeech.setOnClickListener(this);
        buttonSlow = (Button)findViewById(R.id.ButtonSlow);
        buttonSlow.setOnClickListener(this);
        buttonNormal = (Button)findViewById(R.id.ButtonNormal);
        buttonNormal.setOnClickListener(this);
        buttonFast = (Button)findViewById(R.id.ButtonFast);
        buttonFast.setOnClickListener(this);
        buttonLowPitch = (Button)findViewById(R.id.ButtonLowPitch);
        buttonLowPitch.setOnClickListener(this);
        buttonNormalPitch = (Button)findViewById(R.id.ButtonNormalPitch);
        buttonNormalPitch.setOnClickListener(this);
        buttonHighPitch = (Button)findViewById(R.id.ButtonHighPitch);
        buttonHighPitch.setOnClickListener(this);
        
        // TextToSpeechオブジェクトの生成
        tts = new TextToSpeech(this, this);
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	if (null != tts) {
    		// TextToSpeechのリソースを解放する
    		tts.shutdown();
    	}
    }
    
	@Override
	public void onInit(int status) {
		if (TextToSpeech.SUCCESS == status) {
			Locale locale = Locale.ENGLISH;
			if (tts.isLanguageAvailable(locale) >= TextToSpeech.LANG_AVAILABLE) {
				tts.setLanguage(locale);
			} else {
				Log.d("", "Error SetLocale");
			}
		} else {
			Log.d("", "Error Init");
		}
	}

    private void speechText() {
		String string = ((EditText)findViewById(R.id.EditTextSpeech)).getText().toString();
		if (0 < string.length()) {
			if (tts.isSpeaking()) {
				// 読み上げ中なら止める
				tts.stop();
			}
			
			// 読み上げ開始
			tts.speak(string, TextToSpeech.QUEUE_FLUSH, null);
		}
	}

	@Override
	public void onClick(View v) {
		if (buttonSpeech == v) {
			speechText();
		} else if (buttonSlow == v) {
			// 再生速度の設定
			tts.setSpeechRate(SPEECH_SLOW);
		} else if (buttonNormal == v) {
			// 再生速度の設定
			tts.setSpeechRate(SPEECH_NORMAL);
		} else if (buttonFast == v) {
			// 再生速度の設定
			tts.setSpeechRate(SPEECH_FAST);			
		} else if (buttonLowPitch == v) {
			// 再生ピッチの設定
			tts.setPitch(PITCH_LOW);
		} else if (buttonNormalPitch == v) {
			// 再生ピッチの設定
			tts.setPitch(PITCH_NORMAL);
		} else if (buttonHighPitch == v) {
			// 再生ピッチの設定
			tts.setPitch(PITCH_HIGH);
		}
	}
}