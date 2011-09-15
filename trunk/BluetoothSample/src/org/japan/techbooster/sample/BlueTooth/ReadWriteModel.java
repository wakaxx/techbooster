package org.japan.techbooster.sample.BlueTooth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import org.japan.techbooster.sample.BlueTooth.BluetoothClientThread;
import org.japan.techbooster.sample.BlueTooth.BluetoothServerThread;

public class ReadWriteModel extends Thread {
	//ソケットに対するI/O処理
	
	public static InputStream in;
	public static OutputStream out;
	private String sendNumber;
	private Context mContext;
		
	//コンストラクタの定義
	public ReadWriteModel(Context context, BluetoothSocket socket, String string){
		sendNumber = string;
		mContext = context;
		
		try {
			//接続済みソケットからI/Oストリームをそれぞれ取得
			in = socket.getInputStream();
			out = socket.getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	public void write(byte[] buf){
		//Outputストリームへのデータ書き込み
		try {
			out.write(buf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		byte[] buf = new byte[1024];
		String rcvNum = null;
		int tmpBuf = 0;
		
		try {
			write(sendNumber.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
			try {
				tmpBuf = in.read(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(tmpBuf!=0){
				try {
					rcvNum = new String(buf, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			Intent i = new Intent(mContext, StreamActivity.class);
			i.putExtra("NUMBER", rcvNum);
			mContext.startActivity(i);
		}

	}
}
