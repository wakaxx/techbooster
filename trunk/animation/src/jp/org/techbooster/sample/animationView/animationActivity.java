/*
 * http://techbooster.jpn.org/
 * */
package jp.org.techbooster.sample.animationView;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class animationActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Tweenアニメーションの適用
        ImageView img = (ImageView) findViewById(R.id.ImageView01);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.motion);
        animation.setFillAfter(true);	//終了後を保持
        animation.setFillEnabled(true);
        img.startAnimation(animation);

    }
}