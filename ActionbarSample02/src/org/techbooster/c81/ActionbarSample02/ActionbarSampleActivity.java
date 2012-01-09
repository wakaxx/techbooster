package org.techbooster.c81.ActionbarSample02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

public class ActionbarSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // menuファイルの読み込み
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        MenuItem actionItem = menu
            .findItem(R.id.menu_item_share_action_provider_action_bar);

        ShareActionProvider actionProvider = (ShareActionProvider) actionItem
            .getActionProvider();
        actionProvider
            .setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "aaa");
        actionProvider.setShareIntent(shareIntent);

        MenuItem overflowItem = menu
            .findItem(R.id.menu_item_share_action_provider_overflow);
        ShareActionProvider overflowProvider = (ShareActionProvider) overflowItem
            .getActionProvider();
        overflowProvider
            .setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);

        overflowProvider.setShareIntent(shareIntent);

        return true;
    }
}