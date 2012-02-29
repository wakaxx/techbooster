
package org.techbooster.sample.contextmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContextMenuActivity extends Activity {
    private static final int CONTEXT_MENU_IMAGE_VIEW_ITEM_ID_1 = 0;

    private static final int CONTEXT_MENU_IMAGE_VIEW_ITEM_ID_2 = 1;

    private static final int CONTEXT_MENU_TEXT_VIEW_ITEM_ID_1 = 2;

    private static final int CONTEXT_MENU_TEXT_VIEW_ITEM_ID_2 = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // コンテキストメニューを表示させるViewを指定する
        // 複数のView指定することも可能
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);
        registerForContextMenu(imageView);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        int viewId = view.getId();

        // コンテキストメニューの設定
        if (viewId == R.id.imageView) {
            menu.setHeaderTitle("ImageViewのコンテキストメニュー");
            menu.setHeaderIcon(getResources().getDrawable(R.drawable.tb_mini));

            menu.add(0, CONTEXT_MENU_IMAGE_VIEW_ITEM_ID_1, 0, "ImageView メニュー 1");
            menu.add(0, CONTEXT_MENU_IMAGE_VIEW_ITEM_ID_2, 0, "ImageView メニュー 2");
        } else if (viewId == R.id.textView) {
            menu.setHeaderTitle("TextViewのコンテキストメニュー");
            menu.setHeaderIcon(getResources().getDrawable(R.drawable.ic_launcher));

            menu.add(0, CONTEXT_MENU_TEXT_VIEW_ITEM_ID_1, 0, "TextView メニュー 1");
            menu.add(0, CONTEXT_MENU_TEXT_VIEW_ITEM_ID_2, 0, "TextView メニュー 2");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case CONTEXT_MENU_IMAGE_VIEW_ITEM_ID_1:
                // TODO:メニュー押下時の操作
                return true;
            case CONTEXT_MENU_IMAGE_VIEW_ITEM_ID_2:
                // TODO:メニュー押下時の操作
                return true;
            case CONTEXT_MENU_TEXT_VIEW_ITEM_ID_1:
                // TODO:メニュー押下時の操作
                return true;
            case CONTEXT_MENU_TEXT_VIEW_ITEM_ID_2:
                // TODO:メニュー押下時の操作
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
