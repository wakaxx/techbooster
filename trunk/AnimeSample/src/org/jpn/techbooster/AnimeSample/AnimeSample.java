package org.jpn.techbooster.AnimeSample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class AnimeSample extends Activity {
	Spinner spinner;
	Button button;
	ClickListener listener;
	String item;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// アニメーション選択用adapterの作成
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter.add("AlphaAnimation");
		adapter.add("RotateAnimation");
		adapter.add("ScaleAnimation");
		adapter.add("TranslateAnimation");
		adapter.add("AnimationSet");

		// Spinner作成
		spinner = (Spinner) findViewById(R.id.Spinner01);
		spinner.setAdapter(adapter);

		// イベントリスナー登録
		button = (Button) findViewById(R.id.Button01);
		listener = new ClickListener();
		button.setOnClickListener(listener);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				Spinner spinner = (Spinner) parent;
				item = (String) spinner.getSelectedItem();
			}

			public void onNothingSelected(AdapterView<?> parent) {
				//
			}
		});
	}

	class ClickListener implements OnClickListener {
		public void onClick(View v) {
			ImageView img = (ImageView) findViewById(R.id.ImageView01);

			// AlphaAnimation
			if (item.equals("AlphaAnimation")) {
				Log.i("xxx", "AlphaAnimation");

				AlphaAnimation alpha = new AlphaAnimation(1, 0.1f); // 透明度を1から0.1に変化させる
				alpha.setDuration(3000); // 3000msかけてアニメーションする
				img.startAnimation(alpha); // アニメーション適用

			// RotateAnimation
			} else if (item.equals("RotateAnimation")) {
				Log.i("xxx", "RotateAnimation");

				RotateAnimation rotate = new RotateAnimation(0, 360,
						img.getWidth() / 2, img.getHeight() / 2); // imgの中心を軸に、0度から360度にかけて回転
				rotate.setDuration(3000); // 3000msかけてアニメーションする
				img.startAnimation(rotate); // アニメーション適用

			// ScaleAnimation
			} else if (item.equals("ScaleAnimation")) {
				Log.i("xxx", "ScaleAnimation");

				ScaleAnimation scale = new ScaleAnimation(1, 0.5f, 1, 0.5f); // imgを1倍から0.5倍に縮小
				scale.setDuration(3000); // 3000msかけてアニメーションする
				img.startAnimation(scale); // アニメーション適用

			// TranslateAnimation
			} else if (item.equals("TranslateAnimation")) {
				Log.i("xxx", "TranslateAnimation");

				TranslateAnimation translate = new TranslateAnimation(0, 100,
						0, 100); // (0,0)から(100,100)に移動
				translate.setDuration(3000); // 3000msかけてアニメーションする
				img.startAnimation(translate); // アニメーション適用

			// AnimationSet
			} else if (item.equals("AnimationSet")) {
				Log.i("xxx", "AnimationSet");

				AnimationSet set = new AnimationSet(true);

				RotateAnimation rotate = new RotateAnimation(0, 360,
						img.getWidth() / 2, img.getHeight() / 2); // imgの中心を軸に、0度から360度にかけて回転
				set.addAnimation(rotate);

				ScaleAnimation scale = new ScaleAnimation(1, 0.5f, 1, 0.5f); // imgを1倍から0.5倍に縮小
				set.addAnimation(scale);

				set.setDuration(3000); // 3000msかけてアニメーションする
				img.startAnimation(set); // アニメーション適用
			}
		}
	};
}
