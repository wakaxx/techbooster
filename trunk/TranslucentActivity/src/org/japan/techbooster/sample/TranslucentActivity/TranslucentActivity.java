package org.japan.techbooster.sample.TranslucentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TranslucentActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list);
//        adapter.add("red");
//        adapter.add("green");
//        adapter.add("blue");
//        
//        ListView listView = (ListView)findViewById(R.id.listview);
//        listView.setAdapter(adapter);
        
    }
}