package org.jpn.techbooster.sample.progressdialog;


import android.app.Activity;
import android.os.Bundle;
import android.app.ProgressDialog;

public class ProgressDialogActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("処理を実行中しています");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}