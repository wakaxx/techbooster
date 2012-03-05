package org.jpn.techbooster.sample.ringtonemanagersample;

import java.net.URI;

import android.app.Activity;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RingtoneManagerSampleActivity extends Activity {
    Ringtone mRingtone;
    TextView mTextViewTitle;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mTextViewTitle = (TextView)findViewById(R.id.textViewTitle);

        // 現在設定されている着信音を選択する
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        mRingtone = RingtoneManager.getRingtone(getApplicationContext(), uri);

        // 再生開始ボタン
        Button buttonPlay = (Button)findViewById(R.id.buttonPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                 mRingtone.play();  // 再生
                 
                 // 着信音のタイトルを取得して表示する
                 mTextViewTitle.setText(mRingtone.getTitle(getApplicationContext()));
            }
        });

        // 停止ボタン
        Button buttonStop = (Button)findViewById(R.id.buttonStop);
        buttonStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                 mRingtone.stop();  // 停止
                 mTextViewTitle.setText("");
            }
        });
        
        // 一覧表示ボタン
        Button buttonList = (Button)findViewById(R.id.buttonList);
        buttonList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                RingtoneManager ringtoneManager = new RingtoneManager(getApplicationContext());
                Cursor cursor = ringtoneManager.getCursor();
                while (cursor.moveToNext()) {
                    Log.d("Ringtone", "TITLE: " + cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX));
                }
                mRingtone = ringtoneManager.getRingtone(1);
                mRingtone.play();
                mTextViewTitle.setText(mRingtone.getTitle(getApplicationContext()));
            }
        });
       
    }
}