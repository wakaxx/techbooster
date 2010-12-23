/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.fileaccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class fileAccessActivity extends Activity {


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sampleFileOutput();
        sampleFileInput();

        //ファイル削除
        deleteFile(LOCAL_FILE);
    }

    //読み書きするファイル名
    private static final String LOCAL_FILE = "log.txt";

    //ファイルへの書き出し
    private void sampleFileOutput(){

		OutputStream out;
		try {
			out = openFileOutput(LOCAL_FILE,MODE_PRIVATE|MODE_APPEND);
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(out,"UTF-8"));

			//追記する
			writer.append("write test");
			writer.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    }

    private void sampleFileInput(){

       	InputStream in;
		String lineBuffer;

		try {
			in = openFileInput(LOCAL_FILE); //LOCAL_FILE = "log.txt";

			BufferedReader reader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
			while( (lineBuffer = reader.readLine()) != null ){
				Log.d("FileAccess",lineBuffer);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    }
}