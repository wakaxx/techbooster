
package org.jpn.techbooster.sample.DropBoxSample;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DropBoxAuthActivity extends Activity {
    // アプリケーションのApp Key
    final static private String APP_KEY = "";
    // アプリケーションのApp Secret
    final static private String APP_SECRET = "";
    // アプリケーションのアクセスタイプ
    final static private AccessType ACCESS_TYPE = AccessType.APP_FOLDER;

    // DropboxAPIインスタンス
    private DropboxAPI<AndroidAuthSession> mDBApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity_layout);
        
        // 認証処理
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(appKeys, ACCESS_TYPE);
        mDBApi = new DropboxAPI<AndroidAuthSession>(session);
        mDBApi.getSession().startAuthentication(DropBoxAuthActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        
        if (mDBApi.getSession().authenticationSuccessful()) {
            try {
                // 認証処理の終了
                mDBApi.getSession().finishAuthentication();
                
                // AccessTokenPair(認証情報)の取得
                AccessTokenPair tokens = mDBApi.getSession().getAccessTokenPair();

                // 認証情報をSharedPreferencesに保存
                SharedPreferences sp = getSharedPreferences("drop_box_auth", MODE_PRIVATE);
                Editor edit = sp.edit();
                edit.putString("access_tokem", tokens.key);
                edit.putString("access_token_secret", tokens.secret);
                edit.commit();
                
                // 認証情報を表示
                TextView accessTokenTv = (TextView) findViewById(R.id.access_token);
                TextView accessTokenSecretTv = (TextView) findViewById(R.id.access_token_secret);
                accessTokenTv.setText(tokens.key);
                accessTokenSecretTv.setText(tokens.secret);
            } catch (IllegalStateException e) {
                Log.i("DbAuthLog", "Error authenticating", e);
            }
        }
    }
}
