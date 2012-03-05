package org.jpn.techbooster.sample.optionmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {
    // メニューアイテム識別用のID
    private static final int MENU_ID_A = 0;
    private static final int MENU_ID_B = 1;
    private static final int MENU_ID_C = 2;    
    private static final int MENU_ID_D = 3; 
    private static final int SUB_MENU_ID_1 = 10; 
    private static final int SUB_MENU_ID_2 = 20; 
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    // オプションメニューの作成
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        
        // メニューアイテムの追加
        MenuItem menuItemA;
        menuItemA = menu.add(Menu.NONE, MENU_ID_A, Menu.NONE, "アイテム A");
        menuItemA.setIcon(android.R.drawable.ic_menu_call);

        MenuItem menuItemB;
        menuItemB = menu.add(Menu.NONE, MENU_ID_B, Menu.NONE, "アイテム B");
        menuItemB.setIcon(android.R.drawable.ic_menu_compass);

        MenuItem menuItemC;
        menuItemC = menu.add(Menu.NONE, MENU_ID_C, Menu.NONE, "アイテム C");
        menuItemC.setIcon(android.R.drawable.ic_menu_add);
        
        // 4つの目のメニューアイテムはサブメニューにする
        SubMenu subMenu;
        subMenu = menu.addSubMenu(Menu.NONE, MENU_ID_D, Menu.NONE, "アイテム D");
        subMenu.setIcon(android.R.drawable.ic_menu_directions);
        
        // サブメニューにメニューアイテムを追加する
        subMenu.add(Menu.NONE, SUB_MENU_ID_1, Menu.NONE, "サブ アイテム 1");
        subMenu.add(Menu.NONE, SUB_MENU_ID_2, Menu.NONE, "サブ アイテム 2");
     
        return true;
    }
    
    // メニューが選択された時の処理
    public boolean onOptionsItemSelected(MenuItem item) {
        
        // addしたときのIDで識別
        switch (item.getItemId()) {
        case MENU_ID_A:
            Toast.makeText(this, "アイテム A", Toast.LENGTH_LONG).show();
            return true;
     
        case MENU_ID_B:
            Toast.makeText(this, "アイテム B", Toast.LENGTH_LONG).show();
            return true;
            
        case MENU_ID_C:
            Toast.makeText(this, "アイテム C", Toast.LENGTH_LONG).show();
            return true;
        
        // サブメニュー追加したMenuItemも同様に呼ばれる
        case SUB_MENU_ID_1:
            Toast.makeText(this, "サブ アイテム 1", Toast.LENGTH_LONG).show();
            return true;

        case SUB_MENU_ID_2:
            Toast.makeText(this, "サブ アイテム 2", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}