package org.japan.techbooster.sample.BlueTooth;

import android.content.Context;
import android.widget.Toast;

public class Log {
	public static void Log(Context context, String string){
		Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
	}

}
