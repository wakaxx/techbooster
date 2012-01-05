package org.jpn.techbooster.sample.canvassave;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }

    private static class CustomView extends View {

        private Paint mPaint;

        private Bitmap mAndroidGreen;
        private Bitmap mAndroidRed;

        public CustomView(Context context) {
            super(context);
            setFocusable(true);

            mPaint = new Paint();

            Resources res = getResources();
            mAndroidGreen = BitmapFactory.decodeResource(res, R.drawable.android_green);
            mAndroidRed = BitmapFactory.decodeResource(res, R.drawable.android_red);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);

            canvas.drawBitmap(mAndroidGreen, 0, 0, mPaint);
            //現在の状態を覚える
            canvas.save();

            //一時的に移動
            canvas.rotate(45);
            canvas.drawBitmap(mAndroidRed, 0, 0, mPaint);

            //移動した分を元に戻す(-45)
            canvas.restore();
        }
    }
}