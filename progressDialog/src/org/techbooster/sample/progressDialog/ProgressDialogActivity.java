package org.techbooster.sample.progressDialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class ProgressDialogActivity extends Activity implements Runnable {
    ProgressDialog progressDialog;
    Thread thread;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("タイトル");
        progressDialog.setMessage("メッセージ");
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO 自動生成されたメソッド・スタブ
                        Log.d("test", "BUTTON_POSITIVE clicked");
                    }
                });
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // ProgressDialog をキャンセル
                        Log.d("test", "BUTTON_CANCEL clicked");
                        dialog.cancel();
                    }
                });
        progressDialog.show();
 
        thread = new Thread(this);
        thread.start();
    }
 
    @Override
    public void run() {
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        progressDialog.dismiss();
        handler.sendEmptyMessage(0);
    }
 
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "slept 5 seconds",
                    Toast.LENGTH_LONG).show();
        }
    };
}