package org.japan.techbooster.sample.UninstallerSample;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<CustomData> {
	 private LayoutInflater layoutInflater_;
	 
	 public CustomAdapter(Context context, int textViewResourceId, List<CustomData> objects) {
	 super(context, textViewResourceId, objects);
	 layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 }
	 
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	 // 特定の行(position)のデータを得る
	 CustomData item = (CustomData)getItem(position);
	 
	 // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
	 if (null == convertView) {
	 convertView = layoutInflater_.inflate(R.layout.rawitem, null);
	 }
	 
	 // CustomDataのデータをViewの各Widgetにセットする
	 ImageView imageView;
	 imageView = (ImageView)convertView.findViewById(R.id.imageView);
	 imageView.setImageDrawable(item.getImageData());
	 
	 TextView textView;
	 textView = (TextView)convertView.findViewById(R.id.textView);
	 textView.setText(item.getTextData());
	 
	 return convertView;
	 }
	}