package net.npaka.touchex;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.MotionEvent;
import android.widget.TextView;

//タッチイベントの処理
public class TouchView extends View {
    private static int count = 0;
    
    //コンストラクタ
    public TouchView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
    }
    
    //描画
    @Override 
    protected void onDraw(Canvas canvas) {

        count++;        
        //描画オブジェクトの生成
        Paint paint=new Paint(); 
        paint.setAntiAlias(true);
        paint.setTextSize(30);
        
        //タッチXY座標の描画
        canvas.drawText("Count>"+count,0,40*1,paint);

    }
}