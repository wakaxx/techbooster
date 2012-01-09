package org.japan.techbooster.sample.toastsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class ToastSampleActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Ç±Ç±Ç©ÇÁToastï\é¶ÇÃèàóù
//        Toast toast = Toast.makeText(this, "Toast example", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER|Gravity.LEFT, 0, 0);
//        toast.show();
        
        //àÍçsÇ≈ï\é¶ÇµÇƒÇ›ÇÈ
        Toast.makeText(this, "Toast example", Toast.LENGTH_LONG).show();
    }
}