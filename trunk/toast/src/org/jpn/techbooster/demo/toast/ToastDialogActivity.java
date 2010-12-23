/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.toast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ToastDialogActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Toast.makeText(this, "Toast example", Toast.LENGTH_LONG).show();

    }
}