package org.jpn.techbooster.sample.expandableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;

public class expandableList extends ExpandableListActivity {

	// ExpandableList用のAdapter
	private ExpandableListAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 親リスト
		List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
		// 子リスト
		List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();

		// 親リストの項目は3つ
		for (int i = 0; i < 3; i++) {
			// 親リストの項目用のMap変数
			Map<String, String> curGroupMap = new HashMap<String, String>();
			groupData.add(curGroupMap);
			// タイトルを設定する
			curGroupMap.put("TITLE", "Group " + i);

			// 子リストを作成
			List<Map<String, String>> children = new ArrayList<Map<String, String>>();
			// 子リストの項目を作成。各子リストに3つの項目を作成する。
			for (int j = 0; j < 3; j++) {
				// 子リストの項目用のMap変数
				Map<String, String> curChildMap = new HashMap<String, String>();
				children.add(curChildMap);
				// タイトルを設定
				curChildMap.put("TITLE", "Child " + j);
				// サマリーを設定する
				curChildMap.put("SUMMARY", (j % 2 == 0) ? "This child is even" : "This child is odd");
			}
			
			// 子リストを設定
			childData.add(children);
		}

		// アダプタにリストを設定
		mAdapter = new SimpleExpandableListAdapter(
				this,															// コンテキスト
				groupData,														// 親リスト
				android.R.layout.simple_expandable_list_item_1,			// 親リスト用のレイアウト
				new String[] { "TITLE" },									// 親リストで表示する項目のキー
				new int[] { android.R.id.text1,	android.R.id.text2 },	// 親リストレイアウト内で文字を表示するTextViewのID
				childData,														// 子リスト
				android.R.layout.simple_expandable_list_item_2,			// 子リスト用のレイアウト
				new String[] { "TITLE", "SUMMARY" },						// 子リストで表示する項目のキー
				new int[] { android.R.id.text1,	android.R.id.text2 }		// 子リストレイアウト内で文字を表示するTextViewのID
		);
		
		setListAdapter(mAdapter);
	}
}