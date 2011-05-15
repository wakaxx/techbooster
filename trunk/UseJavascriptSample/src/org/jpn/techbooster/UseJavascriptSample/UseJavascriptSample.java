package org.jpn.techbooster.UseJavascriptSample;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class UseJavascriptSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //WebViewの生成
        WebView wv = new WebView(this);

        //WebViewをActivityに配置
        setContentView(wv, new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        //JavaScriptの有効化
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);

        //JavaScriptInterfaceの設定
        wv.addJavascriptInterface(new JavaScriptInterface(this), "AndroidToast");

        //WebViewにページを読み込み
        wv.loadUrl("file:///android_asset/index.html");
    }
}