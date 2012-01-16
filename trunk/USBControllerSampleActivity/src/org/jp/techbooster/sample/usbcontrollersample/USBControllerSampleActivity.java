package org.jp.techbooster.sample.usbcontrollersample;

import java.util.HashMap;
import java.util.Iterator;
import org.jp.techbooster.sample.usbcontrollersample.R;
import android.app.Activity;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class USBControllerSampleActivity extends Activity {
	LinearLayout llayout;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		llayout = (LinearLayout) findViewById(R.id.llayout);

	}

	@Override
	public void onResume() {
		super.onResume();

		//
		UsbManager manager = (UsbManager) getSystemService(this.USB_SERVICE);
		UsbDevice device = manager.getDeviceList().get(
				"Austgame_PS_to_USB_convert_cable");
		HashMap<String, UsbDevice> devMap = manager.getDeviceList();

		if (device != null)
			Log.v("tag-----", device.getDeviceName());

		Iterator<UsbDevice> deviceIterator = devMap.values().iterator();
		int count = 0;
		while (deviceIterator.hasNext()) {

			UsbDevice device1 = deviceIterator.next();
			// your code
			if (device1 != null)
				Log.v("tag--------",
						"Name[" + device1.getDeviceName() + "] DeviceId["
								+ device1.getDeviceId() + "]"
								+ device1.getVendorId());

			Log.v("tag--------", "test" + count++);
		}

	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent ev) {
		if (ev.getAction() == KeyEvent.ACTION_DOWN) {
			// キーコード表示
			TextView tv = new TextView(this);
			tv.setText("DOWN : " + "DeviceId[" + ev.getDeviceId() + "] "
					+ "Source[" + getSourceName(ev.getSource()) + "] "
					+ "KeyCode[" + getKeyCodeName[ev.getKeyCode()] + "] " + ""
					+ ev.getDisplayLabel());
			llayout.addView(tv);
		} else if (ev.getAction() == KeyEvent.ACTION_UP) {

		}
		return super.dispatchKeyEvent(ev);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		super.onTouchEvent(ev);

		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Log.v("MOUSE-TEST","DOWN");
			break;
		case MotionEvent.ACTION_MOVE:
			Log.v("MOUSE-TEST","MOVE");
			break;
		case MotionEvent.ACTION_UP:
			Log.v("MOUSE-TEST","UP");
			break;
		}

		return false;
	}

	private final String getSourceName(int src) {
		String ret = null;
		switch (src) {
		case InputDevice.SOURCE_ANY:
			ret = "SOURCE_ANY";
			break;
		case InputDevice.SOURCE_CLASS_BUTTON:
			ret = "SOURCE_CLASS_BUTTON";
			break;
		case InputDevice.SOURCE_CLASS_JOYSTICK:
			ret = "SOURCE_CLASS_JOYSTICK";
			break;
		case InputDevice.SOURCE_CLASS_MASK:
			ret = "SOURCE_CLASS_MASK";
			break;
		case InputDevice.SOURCE_CLASS_POINTER:
			ret = "SOURCE_CLASS_POINTER";
			break;
		case InputDevice.SOURCE_CLASS_POSITION:
			ret = "SOURCE_CLASS_POSITION";
			break;
		case InputDevice.SOURCE_CLASS_TRACKBALL:
			ret = "SOURCE_CLASS_TRACKBALL";
			break;
		case InputDevice.SOURCE_DPAD:
			ret = "SOURCE_DPAD";
			break;
		case InputDevice.SOURCE_GAMEPAD:
			ret = "SOURCE_GAMEPAD";
			break;
		case InputDevice.SOURCE_JOYSTICK:
			ret = "SOURCE_JOYSTICK";
			break;
		case InputDevice.SOURCE_KEYBOARD:
			ret = "SOURCE_KEYBOARD";
			break;
		case InputDevice.SOURCE_MOUSE:
			ret = "SOURCE_MOUSE";
			break;
		case InputDevice.SOURCE_TOUCHPAD:
			ret = "SOURCE_TOUCHPAD";
			break;
		case InputDevice.SOURCE_TOUCHSCREEN:
			ret = "SOURCE_TOUCHSCREEN";
			break;
		case InputDevice.SOURCE_TRACKBALL:
			ret = "SOURCE_TRACKBALL";
			break;
		case InputDevice.SOURCE_UNKNOWN:
			ret = "SOURCE_UNKNOWN";
			break;
		default:
			ret = "UNKOWN_VAL";
		}
		return ret;
	}

	String getKeyCodeName[] = { "KEYCODE_UNKNOWN", "KEYCODE_SOFT_LEFT",
			"KEYCODE_SOFT_RIGHT", "KEYCODE_HOME", "KEYCODE_BACK",
			"KEYCODE_CALL", "KEYCODE_ENDCALL", "KEYCODE_0", "KEYCODE_1",
			"KEYCODE_2", "KEYCODE_3", "KEYCODE_4", "KEYCODE_5", "KEYCODE_6",
			"KEYCODE_7", "KEYCODE_8", "KEYCODE_9", "KEYCODE_STAR",
			"KEYCODE_POUND", "KEYCODE_DPAD_UP", "KEYCODE_DPAD_DOWN",
			"KEYCODE_DPAD_LEFT", "KEYCODE_DPAD_RIGHT", "KEYCODE_DPAD_CENTER",
			"KEYCODE_VOLUME_UP", "KEYCODE_VOLUME_DOWN", "KEYCODE_POWER",
			"KEYCODE_CAMERA", "KEYCODE_CLEAR", "KEYCODE_A", "KEYCODE_B",
			"KEYCODE_C", "KEYCODE_D", "KEYCODE_E", "KEYCODE_F", "KEYCODE_G",
			"KEYCODE_H", "KEYCODE_I", "KEYCODE_J", "KEYCODE_K", "KEYCODE_L",
			"KEYCODE_M", "KEYCODE_N", "KEYCODE_O", "KEYCODE_P", "KEYCODE_Q",
			"KEYCODE_R", "KEYCODE_S", "KEYCODE_T", "KEYCODE_U", "KEYCODE_V",
			"KEYCODE_W", "KEYCODE_X", "KEYCODE_Y", "KEYCODE_Z",
			"KEYCODE_COMMA", "KEYCODE_PERIOD", "KEYCODE_ALT_LEFT",
			"KEYCODE_ALT_RIGHT", "KEYCODE_SHIFT_LEFT", "KEYCODE_SHIFT_RIGHT",
			"KEYCODE_TAB", "KEYCODE_SPACE", "KEYCODE_SYM", "KEYCODE_EXPLORER",
			"KEYCODE_ENVELOPE", "KEYCODE_ENTER", "KEYCODE_DEL",
			"KEYCODE_GRAVE", "KEYCODE_MINUS", "KEYCODE_EQUALS",
			"KEYCODE_LEFT_BRACKET", "KEYCODE_RIGHT_BRACKET",
			"KEYCODE_BACKSLASH", "KEYCODE_SEMICOLON", "KEYCODE_APOSTROPHE",
			"KEYCODE_SLASH", "KEYCODE_AT", "KEYCODE_NUM",
			"KEYCODE_HEADSETHOOK", "KEYCODE_FOCUS", "KEYCODE_PLUS",
			"KEYCODE_MENU", "KEYCODE_NOTIFICATION", "KEYCODE_SEARCH",
			"KEYCODE_MEDIA_PLAY_PAUSE", "KEYCODE_MEDIA_STOP",
			"KEYCODE_MEDIA_NEXT", "KEYCODE_MEDIA_PREVIOUS",
			"KEYCODE_MEDIA_REWIND", "KEYCODE_MEDIA_FAST_FORWARD",
			"KEYCODE_MUTE", "KEYCODE_PAGE_UP", "KEYCODE_PAGE_DOWN",
			"KEYCODE_PICTSYMBOLS", "KEYCODE_SWITCH_CHARSET",
			"KEYCODE_BUTTON_A", "KEYCODE_BUTTON_B", "KEYCODE_BUTTON_C",
			"KEYCODE_BUTTON_X", "KEYCODE_BUTTON_Y", "KEYCODE_BUTTON_Z",
			"KEYCODE_BUTTON_L1", "KEYCODE_BUTTON_R1", "KEYCODE_BUTTON_L2",
			"KEYCODE_BUTTON_R2", "KEYCODE_BUTTON_THUMBL",
			"KEYCODE_BUTTON_THUMBR", "KEYCODE_BUTTON_START",
			"KEYCODE_BUTTON_SELECT", "KEYCODE_BUTTON_MODE", "KEYCODE_ESCAPE",
			"KEYCODE_FORWARD_DEL", "KEYCODE_CTRL_LEFT", "KEYCODE_CTRL_RIGHT",
			"KEYCODE_CAPS_LOCK", "KEYCODE_SCROLL_LOCK", "KEYCODE_META_LEFT",
			"KEYCODE_META_RIGHT", "KEYCODE_FUNCTION", "KEYCODE_SYSRQ",
			"KEYCODE_BREAK", "KEYCODE_MOVE_HOME", "KEYCODE_MOVE_END",
			"KEYCODE_INSERT", "KEYCODE_FORWARD", "KEYCODE_MEDIA_PLAY",
			"KEYCODE_MEDIA_PAUSE", "KEYCODE_MEDIA_CLOSE",
			"KEYCODE_MEDIA_EJECT", "KEYCODE_MEDIA_RECORD", "KEYCODE_F1",
			"KEYCODE_F2", "KEYCODE_F3", "KEYCODE_F4", "KEYCODE_F5",
			"KEYCODE_F6", "KEYCODE_F7", "KEYCODE_F8", "KEYCODE_F9",
			"KEYCODE_F10", "KEYCODE_F11", "KEYCODE_F12", "KEYCODE_NUM_LOCK",
			"KEYCODE_NUMPAD_0", "KEYCODE_NUMPAD_1", "KEYCODE_NUMPAD_2",
			"KEYCODE_NUMPAD_3", "KEYCODE_NUMPAD_4", "KEYCODE_NUMPAD_5",
			"KEYCODE_NUMPAD_6", "KEYCODE_NUMPAD_7", "KEYCODE_NUMPAD_8",
			"KEYCODE_NUMPAD_9", "KEYCODE_NUMPAD_DIVIDE",
			"KEYCODE_NUMPAD_MULTIPLY", "KEYCODE_NUMPAD_SUBTRACT",
			"KEYCODE_NUMPAD_ADD", "KEYCODE_NUMPAD_DOT", "KEYCODE_NUMPAD_COMMA",
			"KEYCODE_NUMPAD_ENTER", "KEYCODE_NUMPAD_EQUALS",
			"KEYCODE_NUMPAD_LEFT_PAREN", "KEYCODE_NUMPAD_RIGHT_PAREN",
			"KEYCODE_VOLUME_MUTE", "KEYCODE_INFO", "KEYCODE_CHANNEL_UP",
			"KEYCODE_CHANNEL_DOWN", "KEYCODE_ZOOM_IN", "KEYCODE_ZOOM_OUT",
			"KEYCODE_TV", "KEYCODE_WINDOW", "KEYCODE_GUIDE", "KEYCODE_DVR",
			"KEYCODE_BOOKMARK", "KEYCODE_CAPTIONS", "KEYCODE_SETTINGS",
			"KEYCODE_TV_POWER", "KEYCODE_TV_INPUT", "KEYCODE_STB_POWER",
			"KEYCODE_STB_INPUT", "KEYCODE_AVR_POWER", "KEYCODE_AVR_INPUT",
			"KEYCODE_PROG_RED", "KEYCODE_PROG_GREEN", "KEYCODE_PROG_YELLOW",
			"KEYCODE_PROG_BLUE", "KEYCODE_APP_SWITCH", "KEYCODE_BUTTON_1",
			"KEYCODE_BUTTON_2", "KEYCODE_BUTTON_3", "KEYCODE_BUTTON_4",
			"KEYCODE_BUTTON_5", "KEYCODE_BUTTON_6", "KEYCODE_BUTTON_7",
			"KEYCODE_BUTTON_8", "KEYCODE_BUTTON_9", "KEYCODE_BUTTON_10",
			"KEYCODE_BUTTON_11", "KEYCODE_BUTTON_12", "KEYCODE_BUTTON_13",
			"KEYCODE_BUTTON_14", "KEYCODE_BUTTON_15", "KEYCODE_BUTTON_16", };

}