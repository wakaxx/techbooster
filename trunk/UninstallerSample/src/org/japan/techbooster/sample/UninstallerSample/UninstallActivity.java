package org.japan.techbooster.sample.UninstallerSample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
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

public class UninstallActivity extends Activity {
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
        // �f�[�^�̍쐬
        List<CustomData> objects = new ArrayList<CustomData>();
        //PackageManager�̃I�u�W�F�N�g���擾        
        PackageManager pm = this.getPackageManager();
     // 検索条件
        Intent intent = new Intent(Intent.ACTION_MAIN);
        //メモ：http://www.techdoctranslator.com/android/guide/intents-filters
        intent.addCategory(Intent.CATEGORY_HOME);
        // 検索
        final List<ResolveInfo> appInfoList = pm.queryIntentActivities(intent, 0);
        //�C���X�g�[���σp�b�P�[�W�����擾����
//        final List<ApplicationInfo> appInfoList = pm.getInstalledApplications(BIND_AUTO_CREATE);
        
        for(ResolveInfo ai : appInfoList){
        	itemData = new CustomData();
        	if(ai.loadLabel(pm).toString()!=null){
	        	//�A�v�����擾
	        	itemData.setTextData(ai.loadLabel(pm).toString());
        	}else{
        		itemData.setTextData("NoName");
        	}
        		
        	try {
            	//�A�v���̃A�C�R���擾
				icon = pm.getApplicationIcon(ai.activityInfo.packageName);
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
            	ResolveInfo ai = appInfoList.get(position);
            	Uri uri=Uri.fromParts("package",ai.activityInfo.packageName,null);
                Intent intent=new Intent(Intent.ACTION_DELETE,uri);
                startActivity(intent);
            }
        });
    }
}