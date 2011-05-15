package org.jpn.techbooster.SearchViewSample;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class SearchViewSample extends Activity implements
		OnQueryTextListener {

	private String[] array_adapter_data = { "Apple", "Bike", "Cupcake",
			"Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb" };

	private ListView list;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		SearchView search = (SearchView) findViewById(R.id.searchView1);
		list = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, array_adapter_data);
		list.setAdapter(adapter);
		list.setTextFilterEnabled(true);

		// SearchViewの初期表示状態を設定
		search.setIconifiedByDefault(false);

		// SearchViewにOnQueryChangeListenerを設定
		search.setOnQueryTextListener(this);

		// SearchViewのSubmitボタンを使用不可にする
		search.setSubmitButtonEnabled(true);

		// SearchViewに何も入力していない時のテキストを設定
		search.setQueryHint("検索文字を入力して下さい。");
	}

	// SearchViewにテキストを入力する度に呼ばれるイベント
	@Override
	public boolean onQueryTextChange(String newText) {
		if (TextUtils.isEmpty(newText)) {
			list.clearTextFilter();
		} else {
			list.setFilterText(newText.toString());
		}
		return true;
	}

	// SearchViewのSubmitButtonを押下した時に呼ばれるイベント
	@Override
	public boolean onQueryTextSubmit(String query) {
		return false;
	}
}