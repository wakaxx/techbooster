package jp.org.techbooster.sample.SocketServerSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SocketServerSampleActivity extends Activity implements Runnable{
    
    private ServerSocket mServer;
    private Socket mSocket;
    int port = 8080;
    volatile Thread runner = null;
    Handler mHandler = new Handler();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        WifiManager wifiManager =  (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifIinfo = wifiManager.getConnectionInfo();
        int address = wifIinfo.getIpAddress();
        String ipAddressStr = ((address >> 0) & 0xFF) + "."
                + ((address >> 8) & 0xFF) + "." + ((address >> 16) & 0xFF)
                + "." + ((address >> 24) & 0xFF);
        TextView tv = (TextView) findViewById(R.id.tv1);
        tv.setText(ipAddressStr);
        
        if(runner == null){
            runner = new Thread(this);
            runner.start();
        }
        Toast.makeText(this, "スレッドスタート", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void run() {
        try {
            mServer = new ServerSocket(port);
            mSocket = mServer.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
            String message;
            final StringBuilder messageBuilder = new StringBuilder();
            while ((message = in.readLine()) != null){
                messageBuilder.append(message);
            }
            
            mHandler.post(new Runnable() {
                
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), messageBuilder.toString(), Toast.LENGTH_SHORT).show();
                }
            });
            runner.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}