package net.npaka.touchex;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

//タッチイベントの処理
public class TouchEx extends Activity {
    private TouchView   touchView;  //タッチビュー
    private TickHandler tickHandler;//定期処理ハンドラ
    
    //アプリの初期化
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        touchView=new TouchView(this);
        setContentView(touchView);
    }

    //アプリの再開
    @Override
   public void onResume() {
        super.onResume();
        tickHandler=new TickHandler();
        tickHandler.sleep(0);
    }    
    
    //アプリの一時停止
//    @Override
//    public void onPause() {
//        super.onPause();
//       tickHandler=null;
//    }    
    
    //定期処理ハンドラ
    public class TickHandler extends Handler {
        //ハンドルメッセージ
        @Override 
        public void handleMessage(Message msg) {
            touchView.invalidate();
            if (tickHandler!=null) tickHandler.sleep(1000);
        }
        
        //スリープ
        public void sleep(long delayMills) {
            removeMessages(0);
            sendMessageDelayed(obtainMessage(0),delayMills);
        }
    }
}