
package jpn.org.techbooster.sample.pinoauth;

import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * OAuth認証を行う
 * @author kei-i-t
 *
 */
public class AuthTwitterActivity extends Activity implements OnClickListener {

    /**
     * リクエストトークン
     */
    public static RequestToken sRequestToken = null;
    /**
     * 認証情報オブジェクト
     */
    public static OAuthAuthorization sOauth = null;
    public static AccessToken sAccessToken = null;

    /**
     * エラー出力用tag
     */
    private final String mTag = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.auth_twitter_activity_start);

        initLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (sRequestToken != null) {
            // 認証処理に入っている場合はレイアウトを変更
            setContentView(R.layout.auth_twitter_activity_type);
            Button authBtn = (Button) findViewById(R.id.btn_auth_pin);
            authBtn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_auth_twitter) {
            // 認証OKボタン
            connectTwitter();
        } else if (v.getId() == R.id.btn_auth_pin) {
            // PIN認証ボタン
            authPIN();
        }
    }

    /**
     * レイアウトの初期化
     */
    private void initLayout() {
        Button okBtn = (Button) findViewById(R.id.btn_auth_twitter);
        okBtn.setOnClickListener(this);
    }

    /**
     * Twitterに接続する
     */
    private void connectTwitter() {
        // Twitetr4jの設定を読み込む
        Configuration conf = ConfigurationContext.getInstance();
        // Oauth認証オブジェクト作成
        sOauth = new OAuthAuthorization(conf);
        // Oauth認証オブジェクトにconsumerKeyとconsumerSecretを設定
        // Consumer keyとComsumer Secretは各自取得したもので書き換えてください。
        sOauth.setOAuthConsumer("Consumer key",
                "Comsumer Secret");

        // リクエストトークンの作成
        try {
            sRequestToken = sOauth.getOAuthRequestToken();
        } catch (TwitterException e) {
            Log.e(mTag, e.toString());
            return;
        }
        String url = sRequestToken.getAuthorizationURL();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
    
    private void authPIN(){
        EditText et = (EditText) findViewById(R.id.et_input_pin);
        if (et.getText().toString().equals("")) {
            Toast.makeText(this, R.string.err_invalid_pin, Toast.LENGTH_LONG);
            return;
        }
        try {
            sAccessToken = sOauth.getOAuthAccessToken(et.getText().toString());
            
            SharedPreferences sp = getSharedPreferences("twitter_access", MODE_PRIVATE);
            Editor edit = sp.edit();
            edit.putString("access_token", sAccessToken.getToken());
            edit.putString("access_token_secret",
                    sAccessToken.getTokenSecret());
            edit.commit();
            finish();
        } catch (TwitterException e) {
            Log.e(mTag, e.toString());
            Toast.makeText(this, R.string.err_failed_auth, Toast.LENGTH_LONG);
            return;
        }
    }
}
