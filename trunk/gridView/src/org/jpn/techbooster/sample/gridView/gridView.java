package org.jpn.techbooster.sample.gridView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class gridView extends Activity {
	GridView mGrid;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

// グリッドにアダプタを設定する
mGrid = (GridView) findViewById(R.id.myGrid);
mGrid.setAdapter(new myAdapter());
	}

	public class myAdapter extends BaseAdapter {

		/*
		 * mThumbIds：表示する画像のリソースIDをint配列に定義
		 */
private Integer[] mThumbIds = {
		R.drawable.img_01,
		R.drawable.img_02,
		R.drawable.img_03,
		R.drawable.img_01,
		R.drawable.img_02,
		R.drawable.img_03,
		R.drawable.img_01,
		R.drawable.img_02,
		R.drawable.img_03,
		R.drawable.img_01,
		R.drawable.img_02,
		R.drawable.img_03,
		R.drawable.img_01,
		R.drawable.img_02,
		R.drawable.img_03,
};
		
		/*
		 * コンストラクタ
		 */
		public myAdapter() {
			// 特に何もしない
		}

		/*
		 * getViewメソッド：データを表示するためのImageViewを返す
		 */
		public View getView(int position, View convertView, ViewGroup parent) {
			// 画像表示用のImageView
			ImageView imageView;

			// convertViewがnullならImageViewを新規に作成する
			if (convertView == null) {
				imageView = new ImageView(gridView.this);
				imageView.setLayoutParams(new GridView.LayoutParams(50, 50));
			// convertViewがnullでない場合は再利用
			} else {
				imageView = (ImageView) convertView;
			}

			// ImageViewに画像ファイルを設定
			imageView.setImageResource(mThumbIds[position]);

			// ImageViewを返す
			return imageView;
		}

		/*
		 * getCountメソッド：データの個数を返す
		 */
		public final int getCount() {
			// mThumbIdsの大きさを返す
			return mThumbIds.length;
		}

/*
 * getItemメソッド：
 */
public final Object getItem(int position) {
	return position;
}

/*
 * getItemIdメソッド：
 */
public final long getItemId(int position) {
	return position;
}
	}
}