package org.jpn.techbooster.sample;

import java.util.Date;
import org.jpn.techbooster.packageinfosample.R;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class PackageInfoSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView textFirstInstallTime = (TextView)findViewById(R.id.TextFirstInstallTime);
        TextView textLastUpdateTime = (TextView)findViewById(R.id.TextLastUpdateTime);
        
        PackageInfo packageInfo = null;
        try {
                packageInfo = getPackageManager().getPackageInfo("org.jpn.techbooster.packageinfosample", PackageManager.GET_META_DATA);
        } catch (NameNotFoundException e) {
                e.printStackTrace();
        }
        
        // 1970年1月1日午前0時からの経過時間からDateクラスを作成する
        Date dateFirstInstallTime = new Date(packageInfo.firstInstallTime);
        Date dateLastUpdateTime = new Date(packageInfo.lastUpdateTime);
        
        //作成したDateクラス（＝インストール日時、更新日時）を表示する
        textFirstInstallTime.setText("FirstInstallTime : "+ dateFirstInstallTime);
        textLastUpdateTime.setText("LastUpdateTime : "+ dateLastUpdateTime);
    }
}