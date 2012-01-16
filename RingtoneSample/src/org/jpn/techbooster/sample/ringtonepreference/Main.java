package org.jpn.techbooster.sample.ringtonepreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Main extends PreferenceActivity implements
OnSharedPreferenceChangeListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

       /* デフォルトのpreferenceを取得 */
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		/* RingtonePreferenceの設定値取得 */
		String url = sp.getString("alarm_music_key", "");
		if(url == null){
			/* サイレントの場合 */
		}else{
			/* その他 */
			Uri uri = Uri.parse(url);
			MediaPlayer mp = MediaPlayer.create(this, uri);
			mp.setLooping(true);
			mp.seekTo(0);
			mp.start();
		}

    }

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		/* デフォルトのpreferenceを取得 */
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		/* RingtonePreferenceの設定値取得 */
		String url = sp.getString("alarm_music_key", "");
		if(url == null){
			/* サイレントの場合 */
		}else{
			/* その他 */
			Uri uri = Uri.parse(url);
			MediaPlayer mp = MediaPlayer.create(this, uri);
			mp.setLooping(true);
			mp.seekTo(0);
			mp.start();
		}
		
	}
}