package net.sample.techbooster.customviewsample;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CustomButton extends Button implements View.OnClickListener{
	
	Context mContext;
	String className;

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mContext = context;
		setOnClickListener(this);
		//attrs.xmlに定義したスタイルのインスタンスを作成
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.CustomView);

        //レイアウトファイルで定義した値を取得してButtonにセット
        setText(a.getText(0));
        setTextColor(a.getColor(1, 0));
        setTextSize(a.getDimension(2, 0));
        //遷移先のActivityを取得
        className = a.getString(3);
       
	}
	
	@Override
	public void onClick(View v){
		//ボタン押下時に画面遷移
        Intent intent = new Intent();
        intent.setClassName(mContext, className);
        mContext.startActivity(intent);		
	}
}
