package org.jpn.techbooster.sample.onetimemessage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class OneTimeMessageActivity extends Activity {

    public static final int MENU_SELECT_CLEAR = 0;
    public static final int PREFERENCE_INIT = 0;
    public static final int PREFERENCE_BOOTED = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    //ダイアログ表示
    @Override
    public void onResume(){

        super.onResume();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);

        // ダイアログの設定
        alertDialog.setTitle("FirstBoot");          //タイトル
        alertDialog.setMessage("初回メッセージ");      //内容
        alertDialog.setIcon(R.drawable.icon);   //アイコン設定

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
            	//初回表示完了
            	setState(PREFERENCE_BOOTED);
            }
        });

        // ダイアログの作成と表示
        if(PREFERENCE_INIT == getState() ){
        	//初回起動時のみ表示する
        	alertDialog.create();
        	alertDialog.show();
        }
    }


    //メニュー作成
    public boolean onCreateOptionsMenu(Menu menu){
    	//Clearボタンの追加
        menu.add(0, MENU_SELECT_CLEAR, 0, "Clear")
        	.setIcon(android.R.drawable.ic_menu_close_clear_cancel);

        return true;
    }

    //メニュー実行時の処理
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_SELECT_CLEAR:
        	//データを忘れる
        	setState(PREFERENCE_INIT);
            return true;
        }
        return false;
    }


    //データ保存
    private void setState(int state) {
        // SharedPreferences設定を保存
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putInt("InitState", state).commit();

        //ログ表示
        output( String.valueOf(state) );
    }

    //データ読み出し
    private int getState() {
        // 読み込み
    	int state;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        state = sp.getInt("InitState", PREFERENCE_INIT);

        //ログ表示
        output( String.valueOf(state) );
        return state;
    }

    //データ表示
    private void output(String string){
    	TextView tv = (TextView) findViewById(R.id.TextView);
    	tv.setText("Preference: InitState is " + string);
    }

}