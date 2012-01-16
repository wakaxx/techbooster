package org.jp.techbooster.sample.tcblivewallpaper2;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import android.widget.Toast;

public class LiveWallpaperSample2 extends WallpaperService {
	int width, height;

	@Override
	public void onCreate() {
		super.onCreate();
		WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		Display disp = wm.getDefaultDisplay();
		width = disp.getWidth();
		height = disp.getHeight();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public Engine onCreateEngine() {
		/*
		 * Engine���p�������N���X�̃C���X�^���X��Ԃ�
		 */

		return new MyEngine();
	}

	class MyEngine extends Engine {
		Bitmap mImage;

		public MyEngine() {

		}

		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);

			// �f�t�H���g�ł�touchEvent�ŉ�ʂ�Touch���󂯎��Ȃ��B
			//
			setTouchEventsEnabled(true);
			mImage = BitmapFactory.decodeResource(getResources(),
					R.drawable.tbicon);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();

		}

		/*
		 * �ǎ��̕\����\���iHOMEorUNHOME�j�̐؂�ւ����ɌĂяo�����B
		 */
		@Override
		public void onVisibilityChanged(boolean visible) {
			if (visible) {
				Toast.makeText(getApplicationContext(), "visible",
						Toast.LENGTH_LONG);
			} else {
				Toast.makeText(getApplicationContext(), "non-visible",
						Toast.LENGTH_LONG);
			}
		}

		@Override
		public void onSurfaceChanged(SurfaceHolder holder, int format,
				int width, int height) {
			super.onSurfaceChanged(holder, format, width, height);
		}

		@Override
		public void onSurfaceCreated(SurfaceHolder holder) {
			super.onSurfaceCreated(holder);
			doDraw(0, 0);
		}

		@Override
		public void onSurfaceDestroyed(SurfaceHolder holder) {
			super.onSurfaceDestroyed(holder);
		}

		@Override
		public void onOffsetsChanged(float xOffset, float yOffset, float xStep,
				float yStep, int xPixels, int yPixels) {
			Log.v("test", "xOffset[" + xOffset + "] yOffset[" + yOffset + "] xStep["
					+ xStep + "] yStep[" + yStep + "] xPixels[" + xPixels + "] yPixels["
					+ yPixels+"]");

			/*
			//�X�N���[�����̌v�Z
			int screen = (int)(1.0f / xStep);
			
			//���ݕ\�����Ă���X�N���[���i���[���_�j
			int screenNum = xPixels / (480 / screen);
			
			Log.v("test","screen" + screen + "screenNum" + screenNum);
*/
		
		}

		@Override
		public void onTouchEvent(MotionEvent event) {
			if (event.getAction() == MotionEvent.ACTION_MOVE
					|| event.getAction() == MotionEvent.ACTION_DOWN) {
				doDraw((int) event.getX(), (int) event.getY());

			}
			super.onTouchEvent(event);
		}

		public void doDraw(int posX, int posY) {
			Canvas canvas = getSurfaceHolder().lockCanvas();
			Paint paint = new Paint();
			canvas.drawColor(Color.BLACK);
			canvas.drawBitmap(mImage, posX, posY, paint);

			// Lock����Canvas�����A�ق��̕`�揈���X���b�h������΂�����ɁB
			getSurfaceHolder().unlockCanvasAndPost(canvas);
		}
	}

}