package org.jpn.techbooster.sample.OauthSample2;


import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CallBackActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.callback);

    	AccessToken token = null;

    	//Twitterの認証画面から発行されるIntentを取得
    	Uri uri = getIntent().getData();

    	if(uri != null && uri.toString().startsWith("Callback://CallBackActivity")){
    		//oauth_verifierを取得する
    		String verifier = uri.getQueryParameter("oauth_verifier");
    		try {
    			//AccessTokenオブジェクトを取得
				token = OauthSample2._oauth.getOAuthAccessToken(OauthSample2._req, verifier);
			} catch (TwitterException e) {
				e.printStackTrace();
				Log.d("onNewIntent", e.toString());
			}
    	}

    	TextView tv = (TextView)findViewById(R.id.textView1);
    	CharSequence cs = "token：" + token.getToken() + "\r\n" + "token secret：" + token.getTokenSecret();
    	tv.setText(cs);
	}

}
