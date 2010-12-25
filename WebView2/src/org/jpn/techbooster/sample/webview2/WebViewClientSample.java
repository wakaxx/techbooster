package org.jpn.techbooster.sample.webview2;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewClientSample extends WebViewClient {
	private Dialog dialog;
	public WebViewClientSample() {
		super();
		dialog = null;
	}
	
	private void disimissDialog() {
		dialog.dismiss();
		dialog = null;
	}

	// ページ読み込み開始
	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		dialog = new Dialog(view.getContext());
		dialog.setTitle("Now Loading");
		dialog.show();
	}
	
	// ページ読み込み完了
	@Override
	public void onPageFinished(WebView view, String url) {
		disimissDialog();
		Toast.makeText(view.getContext(), view.getTitle(), Toast.LENGTH_LONG).show();
	}

	// ページ読み込み失敗
	@Override
	public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
		if (null != dialog) {
			disimissDialog();
		}
		Toast.makeText(view.getContext(), "ERROR", Toast.LENGTH_LONG).show();		
	}
}
