
package org.techbooster.c81.camerafacedetect;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = "CameraFaceDetect";

    private Camera mCamera;

    // SurfaceViewの生成時、破棄時、変更時に処理を行うためのリスナー
    private SurfaceHolder.Callback mSurfaceListener = new SurfaceHolder.Callback() {
        public void surfaceCreated(SurfaceHolder holder) {
            mCamera = Camera.open();
            try {
                mCamera.setPreviewDisplay(holder);
            } catch (Exception e) {
                Log.d(TAG, "Error: " + e);
                return;
            }
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            mCamera.release();
            mCamera = null;
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            // Camera.Parameters parameters = mCamera.getParameters();
            // parameters.setPreviewSize(width, height);
            // mCamera.setParameters(parameters);
            mCamera.startPreview();

            // 顔検出用のリスナーを登録する
            mCamera.setFaceDetectionListener(new FaceDetectionListener() {

                // 顔が検出された時の処理を記述する
                @Override
                public void onFaceDetection(Face[] faces, Camera camera) {
                    Log.d(TAG, "faces count: " + faces.length);
                    for (Face face : faces) {
                        // サポートされていなければ-1が常に返ってくる
                        Log.d(TAG, "face id: " + face.id);

                        // 顔検出の信頼度 1から100までの値が入っており、100が顔として信頼度が一番高い
                        Log.d(TAG, "face score: " + face.score);

                        // 検出された顔の範囲
                        Log.d(TAG, "face rect: " + face.rect.left + "," + face.rect.top + " - "
                                + face.rect.right + "," + face.rect.bottom);

                        // 以下はサポートされていなければnullが入ってくる
                        if (face.mouth != null) {
                            Log.d(TAG, "face mouth: " + face.mouth.x + "," + face.mouth.y);
                            Log.d(TAG, "face leftEye: " + face.leftEye.x + "," + face.leftEye.y);
                            Log.d(TAG, "face rightEye: " + face.rightEye.x + "," + face.rightEye.y);
                        }
                    }
                }
            });

            // カメラに顔検出開始を指示する
            try {
                if (mCamera.getParameters().getMaxNumDetectedFaces() > 0) {
                    mCamera.startFaceDetection();
                } else {
                    Toast.makeText(getApplicationContext(), "この端末は顔検出に対応していません", Toast.LENGTH_LONG)
                            .show();
                }
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "IllegalArgumentException.");
            } catch (RuntimeException e) {
                Log.e(TAG, "the method fails or the face detection is already running.");
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.addCallback(mSurfaceListener);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
}
