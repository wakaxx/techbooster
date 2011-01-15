package org.jpn.techbooster.sample.maps;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class SampleMaps extends MapActivity {
    /** Called when the activity is first created. */
	private MapView mapView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //MapView生成
        mapView = new MapView(this, "0KJLdRx4d3O-dRRdOBlTJdscVj_TzoHOqSNp-Bw");
        //マップ上でのクリックを有効化
        mapView.setClickable(true);
        //拡大縮小ボタンを表示
        mapView.setBuiltInZoomControls(true);

        setContentView(mapView);        
    }
    
    @Override
    protected boolean isRouteDisplayed(){
    	return false;
    }
}