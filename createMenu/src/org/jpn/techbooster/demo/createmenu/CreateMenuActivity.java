/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.demo.createmenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class CreateMenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public static final int MENU_SELECT_A = 0;
    public static final int MENU_SELECT_B = 1;
    public static final int MENU_SELECT_C = 2;
    public static final int MENU_SELECT_D = 3;
    public static final int MENU_SELECT_E = 4;
    public static final int MENU_SELECT_F = 5;
    public static final int MENU_SELECT_G = 6;
    public static final int MENU_SELECT_H = 7;

    public boolean onCreateOptionsMenu(Menu menu){

    	menu.add(0, MENU_SELECT_A, 0, "Menu A")
    			.setIcon(android.R.drawable.ic_menu_save);
        menu.add(0, MENU_SELECT_B, 0, "Menu B")
		.setIcon(android.R.drawable.ic_menu_help);
        /*
        menu.add(0, MENU_SELECT_C, 0, "Menu C")
		.setIcon(android.R.drawable.ic_menu_upload);
        menu.add(0, MENU_SELECT_D, 0, "Menu D")
		.setIcon(android.R.drawable.ic_menu_always_landscape_portrait);
        menu.add(0, MENU_SELECT_E, 0, "Menu E")
		.setIcon(android.R.drawable.ic_menu_always_landscape_portrait);
        menu.add(0, MENU_SELECT_F, 0, "Menu F")
		.setIcon(android.R.drawable.ic_menu_always_landscape_portrait);
        menu.add(0, MENU_SELECT_G, 0, "Menu G")
		.setIcon(android.R.drawable.ic_menu_always_landscape_portrait);
        menu.add(0, MENU_SELECT_H, 0, "Menu H")
		.setIcon(android.R.drawable.ic_menu_always_landscape_portrait);
         */
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_SELECT_A:
        	Log.d("Menu","Select Menu A");
            return true;

        case MENU_SELECT_B:
        	Log.d("Menu","Select Menu B");
            return true;

        }
        return false;
    }
}