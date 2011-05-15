package org.jpn.techbooster.UseJavascriptSample;

import android.content.Context;
import android.widget.Toast;

public class JavaScriptInterface {
	Context con;

	public JavaScriptInterface(Context c) {
		this.con = c;
	}

	public void showToast(String messege) {
		messege += "[ここからはJavaで付加されたテキストです]";
        Toast.makeText(this.con, messege, Toast.LENGTH_SHORT).show();
    }
}
