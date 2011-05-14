package org.jpn.techbooster.sample.AlarmProviderSample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;

public class AlarmProviderSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Intentの宣言
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        //アラームにセットする時間を指定
        intent.putExtra(AlarmClock.EXTRA_HOUR, 10);
        //アラームにセットするメッセージを指定
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "set by AlarmClock");
        //アラームにセットする分を指定
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 10);
        startActivity(intent);
    }
}