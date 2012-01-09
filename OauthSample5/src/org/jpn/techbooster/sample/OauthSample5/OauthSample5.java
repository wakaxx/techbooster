package org.jpn.techbooster.sample.OauthSample5;

import twitter4j.TwitterException;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OauthSample5 extends Activity {
	public static RequestToken _req = null;
	public static OAuthAuthorization _oauth = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button)findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
				String token = sp.getString("token", "");
				String tokenSecret = sp.getString("token_seacret", "");
				if((token.equals("")) && (tokenSecret.equals(""))){
					executeOauth();	
				}else{
					startActivity(new Intent().setClass(getApplicationContext(), TimelineActivity.class));
				}
			}
		});
    }

    private void executeOauth(){
    	//Twitetr4jの設定を読み込む
    	Configuration conf = ConfigurationContext.getInstance();

    	//Oauth認証オブジェクト作成
    	_oauth = new OAuthAuthorization(conf);
		//Oauth認証オブジェクトにconsumerKeyとconsumerSecretを設定
    	_oauth.setOAuthConsumer("iy2FEHXmSXNReJ6nYQ8FRg", "KYro4jM8BHlLSMsSdTylnTcm3pYaTCiG2UZrYK1yI4");
		//アプリの認証オブジェクト作成
		try {
			_req = _oauth.getOAuthRequestToken("Callback://CallBackActivity");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		String _uri;
		_uri = _req.getAuthorizationURL();
		startActivityForResult(new Intent(Intent.ACTION_VIEW , Uri.parse(_uri)), 0);
    }
}