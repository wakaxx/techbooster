/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.AnimationDrawableActivity;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class AnimationDrawableActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
     super.onWindowFocusChanged(hasFocus);

     ImageView img = (ImageView)findViewById(R.id.ImageView01);
     // AnimationDrawableのXMLリソースを指定
     img.setBackgroundResource(R.drawable.android_animation);

     // AnimationDrawableを取得
     AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

     // アニメーションの開始
     frameAnimation.start();
    }

}