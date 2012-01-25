package org.techbooster.sample.multifragmentsample;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SampleListFragment extends ListFragment {
	private onFragmentListClickedListener listener;
	private static final String[] rows = { "さんぷる", "Sample", "これはさんぷるです",
			"List Items", "さんぷるですよー" };

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, rows));

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		listener.onFragmentListClick(rows[position]);
	}

	/**
	 * ListのClick情報を通知するListener
	 * 
	 */
	public interface onFragmentListClickedListener {
		public void onFragmentListClick(String select);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
			listener = (onFragmentListClickedListener)activity;
	}

}
