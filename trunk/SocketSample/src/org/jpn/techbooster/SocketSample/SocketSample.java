package org.jpn.techbooster.SocketSample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SocketSample extends Activity {

	Socket connection = null;
	BufferedReader reader = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn = (Button) findViewById(R.id.Button01);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				connect();
				login();
			}
		});
	}

	private void connect() {
		TextView tv = (TextView) findViewById(R.id.TextView01);
		try {
			// サーバーへ接続
			connection = new Socket("pop.mail.yahoo.co.jp", 110);

			// メッセージ取得オブジェクトのインスタンス化
			reader = new BufferedReader(new InputStreamReader(connection
					.getInputStream()));

			// サーバーからのメッセージを受信
			String message = reader.readLine();

			// 接続確認
			if (!(message.matches("^\\+OK.*$"))) {
				tv.setText("サーバーからのメッセージ：" + message);
				Toast.makeText(this, "サーバーとの接続に失敗しました。", Toast.LENGTH_SHORT)
						.show();
			} else {
				tv.setText("サーバーからのメッセージ：" + message);
				Toast.makeText(this, "サーバーとの接続に成功しました。", Toast.LENGTH_SHORT)
						.show();
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
			tv.setText("エラー内容：" + e.toString());
			Toast.makeText(this, "サーバーとの接続に失敗しました。", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			e.printStackTrace();
			tv.setText("エラー内容：" + e.toString());
			Toast.makeText(this, "サーバーとの接続に失敗しました。", Toast.LENGTH_SHORT).show();
		} /*finally {
			try {
				// 接続終了処理
				reader.close();
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
				tv.setText("エラー内容：" + e.toString());
				Toast.makeText(this, "サーバーとの接続に失敗しました。", Toast.LENGTH_SHORT)
						.show();
			}
		}*/
	}

	private void login() {
		TextView tv = (TextView) findViewById(R.id.TextView01);

		// 入力されたIDを取得
		EditText id = (EditText) findViewById(R.id.EditText01);
		CharSequence idStr = id.getText();

		// 入力されたパスワードを取得
		EditText pass = (EditText) findViewById(R.id.EditText02);
		CharSequence passStr = pass.getText();

		BufferedWriter writer = null;
		try {
			// メッセージ送信オブジェクトのインスタンス化
			writer = new BufferedWriter(new OutputStreamWriter(
					connection.getOutputStream()));

			// ログインIDの送信
			writer.write(idStr.toString() + "\r\n");
			writer.flush();

			// ログインIDの正否判定
			String message = reader.readLine();
			if (!(message.matches("^\\+OK.*$"))) {
				tv.setText("ID認証：OK\r\n");
			} else {
				tv.setText("ログインIDが不正です。");
				return;
			}

			// ログインパスワードの送信
			writer.write(passStr.toString() + "\r\n");
			writer.flush();

			// ログインパスワードの正否判定
			message = reader.readLine();
			if (!(message.matches("^\\+OK.*$"))) {
				tv.append("パスワード認証：OK");
			} else {
				tv.setText("パスワードが不正です。");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
			tv.setText("エラー内容：" + e.toString());
			Toast.makeText(this, "サーバーとの接続に失敗しました。", Toast.LENGTH_SHORT).show();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				tv.setText("エラー内容：" + e.toString());
				Toast.makeText(this, "サーバーとの接続に失敗しました。", Toast.LENGTH_SHORT).show();
			}
		}
	}
}