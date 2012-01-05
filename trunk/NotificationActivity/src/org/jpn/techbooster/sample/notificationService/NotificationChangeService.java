package org.jpn.techbooster.sample.notificationService;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class NotificationChangeService extends Service {

    // ユニークなIDを取得するために、R.layout.mainのリソースIDを使います
    private static int NOTIFICATION_ID = R.layout.main;

    // 通知処理を行うスレッドの制御用
    private ConditionVariable   mCondition;
    private NotificationManager mNotificationManager;
    @Override
    public void onCreate() {
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //サービスはメインスレッドで実行されるため、処理を止めないように更新処理を別スレッドに。
        Thread thread = new Thread(null, mTask, "NotifyingService");
        mCondition = new ConditionVariable(false);
        thread.start();
    }

    @Override
    public void onDestroy() {
        //サービスの停止時、通知内容を破棄する
        mNotificationManager.cancel(NOTIFICATION_ID);
        //スレッドを停止するため、ブロックを解除
        mCondition.open();
    }

    private int WAIT_TIME = 5000;//5秒単位

    private Runnable mTask = new Runnable() {
        public void run() {
            for (int i = 0; i < 4; ++i) {
                showNotification(R.drawable.maru,"丸を表示しています");
                if (mCondition.block(WAIT_TIME))
                    break;
                showNotification(R.drawable.sankaku,"三角を表示しています");
                if (mCondition.block(WAIT_TIME))
                    break;
                showNotification(R.drawable.onpu,"音符を表示しています");
                if (mCondition.block(WAIT_TIME))
                    break;
            }
            //アニメーションの終了、サービスを終了する
            NotificationChangeService.this.stopSelf();
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    private void showNotification(int drawableId,   CharSequence text) {

    	//通知内容を決定
        Notification notification = new Notification(drawableId, null, System.currentTimeMillis());

        //PendingIntentはタイミングを指定したインテント
        //今回はユーザーがnotificationを選択した時にActivityを起動
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, NotificationActivity.class), 0);

        //notificationを設定
        notification.setLatestEventInfo(this, "NotificationService",
                       text, contentIntent);

        mNotificationManager.notify(NOTIFICATION_ID, notification);
    }

    private final IBinder mBinder = new Binder() {
        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply,
                int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }
    };
}
