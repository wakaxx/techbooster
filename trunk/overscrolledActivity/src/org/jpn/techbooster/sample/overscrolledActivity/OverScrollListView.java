package org.jpn.techbooster.sample.overscrolledActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

public class OverScrollListView extends ListView {
	private final String TAG ="ListView";

	public OverScrollListView(Context context) {
		super(context);
		setOverScrollMode(OVER_SCROLL_ALWAYS);
		init();
	}

	public OverScrollListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		// 常にオーバースクロールで設定
		setOverScrollMode(OVER_SCROLL_ALWAYS);
	}

	// オーバースクロール
	@Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
			int scrollY, int scrollRangeX, int scrollRangeY,
			int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {


		//オーバーライド
		return super.overScrollBy(deltaX, deltaY, scrollX, scrollY,
				scrollRangeX, scrollRangeY, maxOverScrollX, 200,
				isTouchEvent);

	}

	// オーバースクロール実行後
	@Override
	protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
			boolean clampedY) {

		Log.v(TAG, "scrollX:" + scrollX + " scrollY:" + scrollY
				+ " clampedX:" + clampedX + " clampedY:" + clampedX);

		super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);

	}
}