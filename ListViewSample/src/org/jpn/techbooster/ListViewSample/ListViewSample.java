package org.jpn.techbooster.ListViewSample;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewSample extends ListActivity {
    /** Called when the activity is first created. */
	
	static final String[] COUNTRIES = new String[] { "Afghanistan", "Albania", "Algeria", "American Samoa" }; // リストに表示する項目
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.main);
          setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, COUNTRIES)); // リストに表示項目を設定
    }
    
    // リスト項目を選択したときに呼ばれる
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	TextView t = (TextView)v;
    	super.onListItemClick(l, v, position, id);
    	Log.i("ListViewSampleSample", t.getText().toString() + position); // リスト項目の内容と先頭から何番目であるかを示したpositionをログに表示する
    }
}
