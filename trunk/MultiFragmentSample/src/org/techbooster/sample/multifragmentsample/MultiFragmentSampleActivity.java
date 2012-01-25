package org.techbooster.sample.multifragmentsample;

import org.techbooster.sample.multifragmentsample.SampleListFragment.onFragmentListClickedListener;

import com.org.sample.koba.menufragmentsample.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MultiFragmentSampleActivity extends Activity implements onFragmentListClickedListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // tablet/phoneで読み込むlayoutを変更する
        if(isTabletMode()){
        	setContentView(R.layout.main_tab);	
        }else{
        	setContentView(R.layout.main_sp);
        }
        
    }
    
    @Override
	protected void onResume() {
		super.onResume();

		//listの作成
		SampleListFragment listFragment = new SampleListFragment();
		
		//fragmentを配置する
		FragmentTransaction ft = getFragmentManager().beginTransaction();  
		if(isTabletMode()){
			ft.add(R.id.list_container,listFragment);
		}else{
			ft.add(R.id.phone_container,listFragment);
		}
		ft.commit();
  
    }


	/***
     * Androidのソースコードの閾値を利用（width 480dp以上をタブレットとする)
     * @return true:タブレット
     *         false:スマートフォン
     */
    private boolean isTabletMode(){
    	return getResources().getBoolean(R.bool.is_tablet);
    }

    /**
     * SampleListFragmentでListClickされるとよびだされる
     * ここでdetailFragmentを呼び出す
     */
	@Override
	public void onFragmentListClick(String select) {
		//detailFragmentの作成
		SampleDetailFragment detail = new SampleDetailFragment(select);
		
		//fragmentを配置する
		FragmentTransaction ft = getFragmentManager().beginTransaction();  
		if(isTabletMode()){
			ft.add(R.id.detail_container,detail);
		}else{
			ft.add(R.id.phone_container,detail);
		}
		ft.addToBackStack(null);
		ft.commit();
	}
}