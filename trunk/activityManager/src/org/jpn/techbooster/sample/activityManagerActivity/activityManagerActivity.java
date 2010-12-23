/*
 * http://techbooster.jpn.org/
 * */
package org.jpn.techbooster.sample.activityManagerActivity;

import java.util.List;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Bundle;
import android.util.Log;

public class activityManagerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ActivityManager activityManager = ((ActivityManager) getSystemService(ACTIVITY_SERVICE));


        //メモリ情報の取得
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);

        Log.d("ActivityManager","memoryInfo availMem  :"+memoryInfo.availMem);
        Log.d("ActivityManager","memoryInfo lowMemory :"+memoryInfo.lowMemory);
        Log.d("ActivityManager","memoryInfo threshold :"+memoryInfo.threshold);

        //エラー情報の取得
        List<ActivityManager.ProcessErrorStateInfo> errorStateInfo = activityManager.getProcessesInErrorState();

        if(errorStateInfo != null){
        	for (ActivityManager.ProcessErrorStateInfo error : errorStateInfo){

	        	//エラー情報
	            Log.d("ActivityManager","error.condition  :"+error.condition); //  	CRASHED,NOT_RESPONDING,NO_ERROR
	            Log.d("ActivityManager","error.longMsg    :"+error.longMsg);
	            Log.d("ActivityManager","error.shortMsg   :"+error.shortMsg);
	            Log.d("ActivityManager","error.pid        :"+error.pid);
	            Log.d("ActivityManager","error.processName:"+error.processName);
	            Log.d("ActivityManager","error.stackTrace :"+error.stackTrace);
	            Log.d("ActivityManager","error.tag        :"+error.tag);
	            Log.d("ActivityManager","error.uid        :"+error.uid);

	        }
        }

        //起動中のタスク情報
        // <uses-permission android:name="android.permission.GET_TASKS" /> パーミッションが必要
        List<ActivityManager.RunningTaskInfo> taskInfo = activityManager.getRunningTasks(5);

        if(taskInfo != null){
        	for (RunningTaskInfo task : taskInfo){

	        	//エラー情報
	            Log.d("ActivityManager","task.id           :"+task.id);
	            Log.d("ActivityManager","task.description  :"+task.description);
	            Log.d("ActivityManager","task.numActivities:"+task.numActivities);
	            Log.d("ActivityManager","task.numRunning   :"+task.numRunning);
	        }
        }


    }
}