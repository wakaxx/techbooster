package org.jpn.techbooster.sample.webview2;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebView2Activity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        WebView webview = (WebView)findViewById(R.id.web);
        webview.setWebViewClient(new WebViewClientSample());
        webview.loadUrl("http://www.google.co.jp/");
    }
}