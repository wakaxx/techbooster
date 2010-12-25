package org.jpn.techbooster.sample.customlistview;

import java.util.ArrayList;
import java.util.List;

import org.jpn.techbooster.sample.customlistview.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

public class CustomListViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // リソースに準備した画像ファイルからBitmapを作成しておく
        Bitmap image;
        image = BitmapFactory.decodeResource(getResources(), R.drawable.tb);
        
        // データの作成
        List<CustomData> objects = new ArrayList<CustomData>();
        CustomData item1 = new CustomData();
        item1.setImagaData(image);
        item1.setTextData("１つ目");
        
        CustomData item2 = new CustomData();
        item2.setImagaData(image);
        item2.setTextData("The second");

        CustomData item3 = new CustomData();
        item3.setImagaData(image);
        item3.setTextData("Il terzo");
                
        objects.add(item1);
        objects.add(item2);
        objects.add(item3);
        
        CustomAdapter customAdapater = new CustomAdapter(this, 0, objects);
        
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(customAdapater);
    }
}