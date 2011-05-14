package org.jpn.techbooster.sample.CustomTitleBar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomTitleBarActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //タイトル非表示にする
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        //タイトルにレイアウトを指定する
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);

        //カスタマイズしたレイアウトファイルを指定
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);

        //タイトルバーのTextView
        final TextView leftTitle = (TextView) findViewById(R.id.left_title_text);

        //main.xmlのEditText、ボタンの設定
        final EditText leftTextEdit = (EditText) findViewById(R.id.left_text_edit);
        Button leftButton = (Button) findViewById(R.id.left_text_button);

        //ボタンのリスナ登録
        leftButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	leftTitle.setText(leftTextEdit.getText());
            }
        });

        final TextView rightTitle = (TextView) findViewById(R.id.right_title_text);
        final EditText rightTextEdit = (EditText) findViewById(R.id.right_text_edit);
        Button rightButton = (Button) findViewById(R.id.right_text_button);
        rightButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	rightTitle.setText(rightTextEdit.getText());
            }
        });
    }
}