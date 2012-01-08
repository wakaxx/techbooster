package org.techbooster.sample.space;


import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;

public class SpaceSampleActivity extends Activity {
	private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT; 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout1);
        
        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.drawable.tb);
        layout.addView(imageView1, new LinearLayout.LayoutParams(WC, WC));
        
        Space sp = new Space(this);
        layout.addView(sp, new LinearLayout.LayoutParams(20, 20));
        
        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.drawable.tb);
        layout.addView(imageView2, new LinearLayout.LayoutParams(WC, WC));
    }
}