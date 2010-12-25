package org.jpn.techbooster.sample.webview1;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebView1Activity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        WebView webview = (WebView)findViewById(R.id.web);
        webview.loadUrl("http://www.google.co.jp/");
    }
}