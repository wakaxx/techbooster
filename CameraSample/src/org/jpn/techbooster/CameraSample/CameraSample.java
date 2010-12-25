package org.jpn.techbooster.CameraSample;

import java.io.FileOutputStream;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraSample extends Activity {
	private boolean progress;
	private Camera myCamera;
	
	private SurfaceHolder.Callback mSurfaceListener =
		new SurfaceHolder.Callback() {
			// SurfaceViewが破棄されたらカメラを解放
			public void surfaceDestroyed(SurfaceHolder holder) {
				myCamera.release();
				myCamera = null;
			}
			
			// SurfaceViewが生成されたらカメラをオープン
			public void surfaceCreated(SurfaceHolder holder) {
				myCamera = Camera.open();
				try {
					myCamera.setPreviewDisplay(holder);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// SurfaceViewの大きさやフォーマットが変わったらプレビューの大きさを設定
			public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
				Camera.Parameters parameters = myCamera.getParameters();
				parameters.setPreviewSize(width, height);
				myCamera.setParameters(parameters);
				myCamera.startPreview();
			}
		};
		
		// シャッターが押されたときに呼ばれるコールバック
		private Camera.ShutterCallback mShutterListener =
			new Camera.ShutterCallback() {
				public void onShutter() {
					//
				}
			};

		// JPEGイメージ生成後に呼ばれるコールバック
		private Camera.PictureCallback mPictureListener =
			new Camera.PictureCallback() {
				public void onPictureTaken(byte[] data, Camera camera) {
					// SDカードにJPEGデータを保存する
					if (data != null) {
						FileOutputStream myFOS = null;
						try {
							myFOS = new FileOutputStream("/sdcard/camera_test.jpg");
							myFOS.write(data);
							myFOS.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						camera.startPreview();
						progress = false;
					}
				}
			};

			// 画面を押したときに撮影を行い、SDカードにデータを保存する
			@Override
			public boolean onTouchEvent(MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					if (myCamera != null && progress == false) {
						myCamera.takePicture(mShutterListener, null, mPictureListener);
						progress = true;
					}
				}
				return true;
			}
			
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);

    	SurfaceView mySurfaceView = (SurfaceView)findViewById(R.id.surface_view);
    	SurfaceHolder holder = mySurfaceView.getHolder();
    	holder.addCallback(mSurfaceListener);
    	holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
}
