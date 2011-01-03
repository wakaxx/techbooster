package org.jpn.techbooster.sample.overscrolledActivity;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class OverScrolledActivity extends Activity {

	private String[] list = {"alpha","bravo","charlie","delta","echo","foxtrot"};

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        //適当なArrayAdapterを作成。今回は簡単なStringで。
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        //Listにアダプタを設定
        OverScrollListView listView = (OverScrollListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //Debug用にコールバックを登録
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            	OverScrollListView listView = (OverScrollListView) parent;

            	//ItemをToastで表示
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(OverScrolledActivity.this, item, Toast.LENGTH_LONG).show();
            }
        });
    }
}