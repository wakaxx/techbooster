package org.jpn.techbooster.sample.zipExtractor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class zipExtractor extends Activity {
	ZipInputStream in = null;
	BufferedOutputStream out = null;

	Button button;
	EditText editText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button = (Button) findViewById(R.id.button1);
		editText = (EditText) findViewById(R.id.editText1);

		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				// 外部ストレージのパス
				File externalStoragePath = Environment
						.getExternalStorageDirectory();
				ZipEntry zipEntry = null;
				int data = 0;

				// 入力対象のZIPファイル
				String inputFiles = new String();
				inputFiles = externalStoragePath + "/" + editText.getText();

				Log.i("zipExtractor", "" + inputFiles);

				try {
					in = new ZipInputStream(new BufferedInputStream(
							new FileInputStream(inputFiles)));

					// ZIPファイルに含まれるエントリに対して順にアクセス
					while ((zipEntry = in.getNextEntry()) != null) {
						// 出力用ファイルストリームの生成
						out = new BufferedOutputStream(new FileOutputStream(
								externalStoragePath + "/" + zipEntry.getName()));

						// エントリの内容を出力
						while ((data = in.read()) != -1) {
							out.write(data);
						}

						in.closeEntry();
						out.close();
						out = null;
					}
				} catch (FileNotFoundException e) {
					Log.i("zipExtractor", "FileNotFoundException");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
