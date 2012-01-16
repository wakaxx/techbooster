package jp.org.techbooster.sampletextview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class SampleTextViewActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // 1つ目のTextView
        // default TextView
        // @+id/defaultTextView
        
        // 2つ目のTextView
		// 文字列の設定
        TextView textSetting = (TextView)findViewById(R.id.textSetting);
        textSetting.setText("てきすとの書き込み");
        
        // 3つ目のTextView(XML)
        // 文字サイズの指定（用意されたスタイルを使用） Small
        
        // 4つ目のTextView(XML)
        // 文字サイズの指定（用意されたスタイルを使用） Middle

        // 5つ目のTextView(XML)
        // 文字サイズの指定（用意されたスタイルを使用） Large

        // 6つ目のTextView
        // 文字サイズの変更 (XMLで指定するときは -> android:textSize)
        TextView sizeEdit = (TextView)findViewById(R.id.editSize);
        sizeEdit.setTextSize(18.0f);

		// 7つ目のTextView
        // 色の指定（XML）
        
        // 8つ目のTextView
        // 色の指定
        TextView colorEdit = (TextView)findViewById(R.id.editColor);
//        colorEdit.setTextColor(Color.BLUE);
        colorEdit.setTextColor(0xFF0000ff);
        // 9つ目のTextView
        // 上寄せ　背景水色(XML)
        
        // 10個目のTextView
        // 下寄せ 中央 背景灰色
        TextView bottomText = (TextView)findViewById(R.id.down);
        bottomText.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);
        bottomText.setBackgroundColor(Color.GRAY);
        
        // 11個目のTextView
        // 左側に画像表示(XML)
        
        // 12個目のTextView
        // 右側に画像表示
        Drawable image = getResources().getDrawable(R.drawable.tb);
        image.setBounds(0, 0, 50, 50);
        TextView right_image = (TextView)findViewById(R.id.right_image);
        right_image.setCompoundDrawables(null, null, image, null);
        
        
        // 13個目のTextView
        // フォントとスタイルの変更
		TextView styleAndFont = (TextView) findViewById(R.id.style_and_font);
		styleAndFont.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC|Typeface.BOLD);
		
		// 14個目のTextView
		// Origin Font
		// ApplicationのAssetManagerを引き渡す
		TextView origin_font = (TextView) findViewById(R.id.origin_font);
		origin_font.setTypeface(Typeface.createFromAsset(getAssets(), "plok.ttf"));

	}
	
}