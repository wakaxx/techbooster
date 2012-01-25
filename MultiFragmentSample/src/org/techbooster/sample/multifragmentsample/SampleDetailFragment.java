package org.techbooster.sample.multifragmentsample;

import com.org.sample.koba.menufragmentsample.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SampleDetailFragment extends Fragment {
	private String selectData = null;
	
	public SampleDetailFragment(String select){
		selectData = select;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.detail_fragment, null);
		((TextView) rootView.findViewById(R.id.textView1)).setText(selectData);
		return rootView;
	}
	
	
	
	
}
