/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.customDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class customDialogActivity extends Activity {

    private static final int CUSTOM_DIALOG = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //buttonを取得
        Button btn = (Button)findViewById(R.id.Button01);

        //buttonにダイアログ表示処理を追加
        btn.setOnClickListener( new OnClickListener() {
            public void onClick(View v) {
            	//ダイアログ表示処理を実装
            	showDialog(CUSTOM_DIALOG);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {

        case CUSTOM_DIALOG:

	        //レイアウトの呼び出し
	        LayoutInflater factory = LayoutInflater.from(this);
	        final View inputView = factory.inflate(R.layout.input_dialog, null);

	        //ダイアログの作成(AlertDialog.Builder)
	        return new AlertDialog.Builder(customDialogActivity.this)
	            .setIcon(android.R.drawable.ic_dialog_alert)
	            .setTitle(R.string.dialog_name)
	            .setView(inputView)
	            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int whichButton) {

	                    /* int whichButton により、押されたボタンを判定 */
	                	/* 受付処理 ：入力されたテキストの処理など */
	                }
	            })
	            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int whichButton) {
	                    /* キャンセル処理 */
	                }
	            })
	            .create();
        }

        return null;
    }

}