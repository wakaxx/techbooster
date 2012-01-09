package jpn.org.techbooster.sample.SampleActionProvider;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class SampleActionProviderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// menuのレイアウトファイル読み込み
        getMenuInflater().inflate(R.menu.action_provider_sample_menu, menu);
 
        menu.findItem(R.id.original_provider).setActionProvider(new SampleActionProvider(this));
        return super.onCreateOptionsMenu(menu);
    }
}