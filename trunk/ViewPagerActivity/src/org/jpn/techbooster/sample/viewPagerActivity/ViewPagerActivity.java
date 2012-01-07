package org.jpn.techbooster.sample.viewPagerActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

public class ViewPagerActivity extends Activity {


	private Context mContext;
    private MyPagerAdapter mPagerAdapter;
	private ViewPager mViewPager;
	private static int NUM_OF_VIEWS = 5;
	private static int[] mViewColor = {Color.RED, Color.BLACK, Color.BLUE, Color.GREEN, Color.DKGRAY};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mContext = this;

        mPagerAdapter = new MyPagerAdapter();
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mPagerAdapter);

    }

    private class MyPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			//Pagerに登録したビューの数を返却。サンプルは固定なのでNUM_OF_VIEWS
			return NUM_OF_VIEWS;
		}

	    /**
	     * ページを生成する
	     * position番目のViewを生成し返却するために利用
	     * @param container: 表示するViewのコンテナ
	     * @param position : インスタンス生成位置
	     * @return ページを格納しているコンテナを返却すること。サンプルのようにViewである必要は無い。
	     */
		@Override
		public Object instantiateItem(View collection, int position) {
			TextView tv = new TextView(mContext);
			tv.setText("Hello, world! myPostion :" + position);
			tv.setTextColor(Color.WHITE);
			tv.setTextSize(30);
			tv.setBackgroundColor(mViewColor[position]);

			((ViewPager) collection).addView(tv,0);

			return tv;
		}

		/**
	     * ページを破棄する。
	     * postion番目のViweを削除するために利用
	     * @param container: 削除するViewのコンテナ
	     * @param position : インスタンス削除位置
	     * @param object   : instantiateItemメソッドで返却したオブジェクト
	     */
		@Override
		public void destroyItem(View collection, int position, Object view) {
			//ViewPagerに登録していたTextViewを削除する
			((ViewPager) collection).removeView((TextView) view);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			//表示するViewがコンテナに含まれているか判定する(表示処理のため)
			//objecthainstantiateItemメソッドで返却したオブジェクト。
			//今回はTextViewなので以下の通りオブジェクト比較
			return view==((TextView)object);
		}

		@Override
		public void startUpdate(View arg0) {}

		@Override
		public void finishUpdate(View arg0) {}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {}

		@Override
		public Parcelable saveState() {
			return null;
		}


    }

}