package org.jpn.techbooster.sample.zipCompressor;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class zipCompressor extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// 外部ストレージのパス
		File externalStoragePath = Environment.getExternalStorageDirectory();

		// 入力ストリーム
		InputStream is = null;

		// ZIP形式の出力ストリーム
		ZipOutputStream zos = null;

		// 入力対象のJPGファイル
		String inputFiles[] = new String[2];
		inputFiles[0] = externalStoragePath + "/Sample/Sample1.jpg";
		inputFiles[1] = externalStoragePath + "/Sample/Sample2.jpg";

		// 出力対象のZIPファイル
		String zipfile = externalStoragePath + "/Sample/output.zip";
		Log.i("zipCompressor", "OutputFile:" + zipfile);

		// 入出力用のバッファを作成
		byte[] buf = new byte[1024];

		// ZipOutputStreamオブジェクトの作成
		try {
			zos = new ZipOutputStream(new FileOutputStream(zipfile));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			for (int i = 0; i < inputFiles.length; i++) {
				// 入力ストリームのオブジェクトを作成
				is = new FileInputStream(inputFiles[i]);

				// ZIPエントリを作成。名前は入力ファイルのファイル名
				ZipEntry ze = new ZipEntry(inputFiles[i]);

				// 作成したZIPエントリを登録
				zos.putNextEntry(ze);

				// 入力ストリームからZIP形式の出力ストリームへ書き出す
				int len = 0;
				while ((len = is.read(buf)) != -1) {
					zos.write(buf, 0, len);
				}

				// 入力ストリームを閉じる
				is.close();

				// エントリをクローズする
				zos.closeEntry();
			}

			// 出力ストリームを閉じる
			zos.close();

			Log.i("zipCompressor", "Compress Successful.");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			Log.i("zipCompressor", "FileNotFound");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}