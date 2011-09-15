package org.japan.techbooster.sample.MultiSelectList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChoicedItemsList extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.checked_item);
	    
	    String items = null;
	    
	    items = getIntent().getExtras().getString("choiced_item");
	    
	    TextView textView = (TextView)findViewById(R.id.textView1);
	    textView.setText(items);
	    
    }
}
