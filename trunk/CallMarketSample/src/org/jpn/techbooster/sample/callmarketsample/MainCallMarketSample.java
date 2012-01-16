package org.jpn.techbooster.sample.callmarketsample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainCallMarketSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /**
         * market://search?q=<search-word> or <package-name>
         * market://search?q=pub:<developer-name>
         * market://details?id=<package-name>
         */
//        Uri uri = Uri.parse("market://search?q=GoodMorningTweet");
//        Uri uri = Uri.parse("market://search?q=pub:seit");
        Uri uri = Uri.parse("market://details?id=com.udg.goodmorning.tweet");
        
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
        
        
    }
}