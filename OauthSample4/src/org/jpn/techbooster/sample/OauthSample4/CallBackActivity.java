package org.jpn.techbooster.sample.OauthSample4;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
				token = OauthSample4._oauth.getOAuthAccessToken(OauthSample4._req, verifier);
			} catch (TwitterException e) {
				e.printStackTrace();
			}
    	}
    	
    	//SharedPreferencesにtokenとtoken seacretを保存
    	SharedPreferences spObj = getSharedPreferences("token", MODE_PRIVATE);
    	SharedPreferences.Editor editor = spObj.edit();
    	editor.putString("token", token.getToken());
    	editor.putString("token_seacret", token.getTokenSecret());
    	editor.commit();
    	
    	startActivity(new Intent().setClass(getApplicationContext(), TimelineActivity.class));
    	
    	//ツイートボタン押下時処理
    	Button btn = (Button)findViewById(R.id.tweetButton);
    	btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText ed = (EditText)findViewById(R.id.tweetText);
				if(!(ed.getText().toString().equals(""))){
					tweet(ed.getText().toString());
				}
			}
		});
    	
	}

	private void tweet(String tweetText){
		//SharedPreferencesからtokenとtoken secretの取得
		SharedPreferences spObj = getSharedPreferences("token", MODE_PRIVATE);
		String tokenStr = spObj.getString("token", "");
		String tokenSecretStr = spObj.getString("token_seacret", "");
		
		//twitterオブジェクトの作成
		Twitter tw = new TwitterFactory().getInstance();
		
		//AccessTokenオブジェクトの作成
		AccessToken at = new AccessToken(tokenStr, tokenSecretStr);
		
		//Consumer keyとConsumer key seacretの設定
		tw.setOAuthConsumer("iy2FEHXmSXNReJ6nYQ8FRg", "KYro4jM8BHlLSMsSdTylnTcm3pYaTCiG2UZrYK1yI4");
		
		//AccessTokenオブジェクトを設定
		tw.setOAuthAccessToken(at);

		//ツイート送信
		try {
			tw.updateStatus(tweetText);
		} catch (TwitterException e) {
			e.printStackTrace();
			Toast.makeText(this, "ネットーワークの問題です", Toast.LENGTH_LONG);
		}
	}
}
