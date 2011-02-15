package org.jpn.techbooster.sample.FaceDetector;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private static final int MAX_FACES = 5;
	private static final String TAG = "FaceDetectorSample";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // 画像の読み込み
        String filePath = Environment.getExternalStorageDirectory().getPath() + "/sample.jpg";
        Bitmap image = BitmapFactory.decodeFile(filePath);
        
        // 顔認識処理
        FaceDetector faceDetector = new FaceDetector(image.getWidth(), image.getHeight(), MAX_FACES);
        
        Face[] faces = new Face[MAX_FACES];
        int num = faceDetector.findFaces(image, faces);
        Log.d(TAG, "the number of faces found:" + String.valueOf(num));
        
        // 結果の表示
        for (int i = 0; i < num; i++) {
        	PointF point = new PointF();
        	faces[i].getMidPoint(point);
            Log.d(TAG, "Number" + i + " confidence:" + faces[i].confidence());
            Log.d(TAG, "Number" + i + " eyesDistance:" + faces[i].eyesDistance());
            Log.d(TAG, "Number" + i + " the position of the mid-point between the eyes:" + point.x + "," + point.y);
        }
        
        // 画像に認識した結果を描画する
        Bitmap imageCopy = image.copy(Config.ARGB_8888, true);
        Canvas canvas = new Canvas(imageCopy);
        Paint paint = new Paint();
        paint.setColor(Color.argb(255, 255, 0, 0));
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(3.0f);
        
        for (int i = 0; i < num; i++) {
        	PointF point = new PointF();
        	faces[i].getMidPoint(point);
        	canvas.drawRect(point.x - faces[i].eyesDistance(),
        					point.y - faces[i].eyesDistance(),
        					point.x + faces[i].eyesDistance(),
        					point.y + faces[i].eyesDistance(),
        					paint);
        }        
        
        ImageView imageView = (ImageView)findViewById(R.id.ImageView);
        imageView.setImageBitmap(imageCopy);
    }
}