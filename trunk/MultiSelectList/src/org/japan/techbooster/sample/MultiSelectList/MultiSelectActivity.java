package org.japan.techbooster.sample.MultiSelectList;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MultiSelectActivity extends ListActivity {
    /** Called when the activity is first created. */

	//start1
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.main);
        
        Button button = (Button)findViewById(R.id.Button1);
        
        final ListView listView = getListView();
        listView.setItemsCanFocus(false);
        //選択モードを指定する
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);        
        
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, GENRES));
        
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				String choicedItem = "";
				//マップの情報を取得する
				SparseBooleanArray checked = listView.getCheckedItemPositions(); 
				
				for(int i=0; i<=GENRES.length;i++){
					//マッピングされている(選択されている)項目だった場合は文字列に連結する
					if(checked.get(i) == true){
						choicedItem = choicedItem + GENRES[i] + "\n";
					}
				}
				
				Intent intent = new Intent(getApplicationContext(), ChoicedItemsList.class);
				intent.putExtra("choiced_item", choicedItem);
				startActivity(intent);
			}
        });

    	//start2
//        listView.setOnItemClickListener( new OnItemClickListener(){
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//						long arg3) {
//	
//				int checkedCount = 0;
//				SparseBooleanArray checked = listView.getCheckedItemPositions(); 
//				
//				for(int i=1; i<=checked.size();i++){
//					if(checked.get(i) == true){
//						checkedCount++;
//					}
//				}
//				Toast.makeText(getApplicationContext(), "選択数 :" + checkedCount, Toast.LENGTH_SHORT).show();
//			}
//	    });
        //end2
    }
    //end1

    private static final String[] GENRES = new String[] {
        "mhidaka", "kacchi0516", "rongon_xp", "kobashinG", "seit", "kei_i_t", "furusin_oriver"
    };
}