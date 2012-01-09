package org.jpn.techbooster.sample.HTTPSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HTTPSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView tv = (TextView)findViewById(R.id.textView1);
        HttpURLConnection con = null;
        try {
        	// URLの作成
			URL url = new URL("http://techbooster.jpn.org/");
			
			// 接続用HttpURLConnectionオブジェクト作成
			con = (HttpURLConnection)url.openConnection();
			// リクエストメソッドの設定
			con.setRequestMethod("GET");
			// 
			con.setInstanceFollowRedirects(false);
			// ヘッダーの設定(複数設定可能)
			con.setRequestProperty("Accept-Language", "jp");
			
			// 接続
			con.connect();
			
			// ヘッダーの取得
			Map headers = con.getHeaderFields();
			Iterator headerIt = headers.keySet().iterator();
			String header = null;
			while(headerIt.hasNext()){
				String headerKey = (String)headerIt.next();
				header += headerKey + "：" + headers.get(headerKey) + "\r\n";
			}
			tv.setText(header);
			
			// 本文の取得
			String body = null;
			InputStream in = con.getInputStream();
			byte bodyByte[] = new byte[1024];
			in.read(bodyByte);
			in.close();
			tv.setText(new String(bodyByte));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		    con.disconnect();
		}
    }
}