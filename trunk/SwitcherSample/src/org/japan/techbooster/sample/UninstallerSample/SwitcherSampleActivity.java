package org.japan.techbooster.sample.UninstallerSample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import org.japan.techbooster.sample.UninstallerSample.CustomData;
import org.japan.techbooster.sample.UninstallerSample.CustomAdapter;

public class SwitcherSampleActivity extends Activity {
    /** Called when the activity is first created. */
	private ListView listView = null;
	private ImageView imageView = null;
	private TextView textView = null;
	private Drawable icon = null;
	private CustomData itemData;
	private CustomAdapter customAdapater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    	imageView = (ImageView)findViewById(R.id.imageView);
    	textView = (TextView)findViewById(R.id.textView);
        
        listView = (ListView)findViewById(R.id.appList);
        List<CustomData> objects = new ArrayList<CustomData>();
        PackageManager pm = this.getPackageManager();
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        //呼び出したいActivityのカテゴリを指定する
        intent.addCategory(Intent.CATEGORY_HOME);]
        //カテゴリとアクションに一致するアクティビティの情報を取得する
        final List<ResolveInfo> appInfoList = pm.queryIntentActivities(intent, 0);
        
        for(ResolveInfo ri : appInfoList){
        	itemData = new CustomData();

        	if(ri.loadLabel(pm).toString()!=null){
	        	itemData.setTextData(ri.loadLabel(pm).toString());
        	}else{
        		itemData.setTextData("NoName");
        	}
        		
        	try {
				icon = pm.getApplicationIcon(ri.activityInfo.packageName);
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
        	itemData.setImageData(icon);
        	
        	objects.add(itemData);
        	customAdapater = new CustomAdapter(this, 0, objects);
            listView.setAdapter(customAdapater);
        }
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	ResolveInfo ri = appInfoList.get(position);
            	Uri uri=Uri.fromParts("package",ri.activityInfo.packageName,null);
                Intent intent=new Intent();
                intent.setData(uri);
                ComponentName cn = ComponentName.unflattenFromString("com.android.settings/.applications.InstalledAppDetails");
                intent.setComponent(cn);
                startActivity(intent);
            }
        });
    }
}