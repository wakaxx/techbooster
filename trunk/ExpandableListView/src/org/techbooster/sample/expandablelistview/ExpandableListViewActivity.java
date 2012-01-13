package org.techbooster.sample.expandablelistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

public class ExpandableListViewActivity extends Activity {
    int PARENT_DATA = 3;
    int CHILD_DATA = 3;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        // 親ノードのリスト
        List<Map<String, String>> parentList = new ArrayList<Map<String, String>>();
        // 全体の子ノードのリスト
        List<List<Map<String, String>>> allChildList = new ArrayList<List<Map<String, String>>>();
 
        // 親ノードに表示する内容を生成
        for (int i = 0; i < PARENT_DATA; i++) {
            Map<String, String> parentData = new HashMap<String, String>();
            parentData.put("title", "title" + Integer.toString(i));
            // 親ノードのリストに内容を格納
            parentList.add(parentData);
        }
 
        // 子ノードに表示する文字を生成
        for (int i = 0; i < PARENT_DATA; i++) {
            // 子ノード全体用のリスト
            List<Map<String, String>> childList = new ArrayList<Map<String, String>>();
 
            // 各子ノード用データ格納
            for (int j = 0; j < 3; j++) {
                Map<String, String> childData = new HashMap<String, String>();
                childData.put("TITLE", "child" + Integer.toString(j));
                childData.put("SUMMARY", "summary" + Integer.toString(j));
                // 子ノードのリストに文字を格納
                childList.add(childData);
            }
            // 全体の子ノードリストに各小ノードリストのデータを格納
            allChildList.add(childList);
        }
 
        // アダプタを作る
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, parentList,
                android.R.layout.simple_expandable_list_item_1,
                new String[] { "title" }, new int[] { android.R.id.text1 },
                allChildList, android.R.layout.simple_expandable_list_item_2,
                new String[] { "TITLE", "SUMMARY" }, new int[] {
                        android.R.id.text1, android.R.id.text2 });
 
        ExpandableListView lv = (ExpandableListView) findViewById(R.id.expandableListView1);
        //生成した情報をセット
        lv.setAdapter(adapter);
 
        // リスト項目がクリックされた時の処理
        lv.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view,
                    int groupPosition, int childPosition, long id) {
                ExpandableListAdapter adapter = parent
                        .getExpandableListAdapter();
 
                // クリックされた場所の内容情報を取得
                Map<String, String> item = (Map<String, String>) adapter
                        .getChild(groupPosition, childPosition);
 
                // トーストとして表示
                Toast.makeText(
                        getApplicationContext(),
                        "child clicked " + item.get("TITLE") + " "
                                + item.get("SUMMARY"), Toast.LENGTH_LONG)
                        .show();
                return false;
            }
        });
 
        // グループの親項目がクリックされた時の処理
        lv.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View view,
                    int groupPosition, long id) {
 
                ExpandableListAdapter adapter = parent
                        .getExpandableListAdapter();
 
                // クリックされた場所の内容情報を取得
                Map<String, String> item = (Map<String, String>) adapter
                        .getGroup(groupPosition);
 
                Toast.makeText(getApplicationContext(),
                        "parent clicked " + item.get("title"),
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}