/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

public class AlertDialogActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);

        /* ダイアログの設定 */
        alertDialog.setTitle("title");			//タイトル
        alertDialog.setMessage("massage");		//内容
        alertDialog.setIcon(R.drawable.icon);	//アイコン設定

        /* OKボタンの設定 */
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// TODO 自動生成されたメソッド・スタブ
				Log.d("AlertDialog", "Positive which :" + which);
			}
		});

        /* SKIPボタンの設定 */
        alertDialog.setNeutralButton("SKIP", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
				// TODO 自動生成されたメソッド・スタブ
				Log.d("AlertDialog", "Neutral which :" + which);
			}
		});

        /* NGボタンの設定 */
        alertDialog.setNegativeButton("NG", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO 自動生成されたメソッド・スタブ
				Log.d("AlertDialog", "Negative which :" + which);

			}
		});

        /* ダイアログの作成と表示 */
        alertDialog.create();
        alertDialog.show();

    }
}