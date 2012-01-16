package org.jp.techbooster.sample.onoff_fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main extends Activity {
	private int counter = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button bt = (Button)findViewById(R.id.button1);
        bt.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                addFragmentToStack();
            }
        });
        
        if (savedInstanceState == null) {
        	Fragment newFragment1 = new UpFragment(counter);
        	FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.fragment01, newFragment1).commit();
        } else {
        }
    }
    
    void addFragmentToStack() {
        // Instantiate a new fragment.
        Fragment newFragment = new UpFragment(counter++);

        // Add the fragment to the activity, pushing this transaction
        // on to the back stack.
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment01, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

    
    
    public static class UpFragment extends Fragment implements OnClickListener {
    	public static String TAG = "FragmentLifeCycle";
    	int cnt;
    	UpFragment(int counter){
    		cnt = counter;
    	}
    	
    	@Override
    	public void onAttach(Activity act){
    		super.onAttach(act);
    		Log.d(TAG,"Fragment-onAttach");
    	}
    	
    	
    	@Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
    		Log.d(TAG,"Fragment-onCreate");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
    		Log.d(TAG,"Fragment-onCreateView");
        	View v = inflater.inflate(R.layout.component_button,container,false);
        	View bt = v.findViewById(R.id.button1);
        	((Button)bt).setOnClickListener(this);
        	((Button)bt).setText("Load the TextView-Fragment"+cnt);
        	
        	return v;
        }
        
        @Override
        public void onActivityCreated(Bundle bundle){
        	super.onActivityCreated(bundle);
    		Log.d(TAG,"Fragment-onActivityCreated");
        }
        
        @Override
        public void onStart(){
        	super.onStart();
    		Log.d(TAG,"Fragment-onStart");
        }
        
        @Override
        public void onResume(){
        	super.onResume();
    		Log.d(TAG,"Fragment-onResume");
        }
        
        @Override
        public void onPause(){
        	super.onPause();
    		Log.d(TAG,"Fragment-onPause");
        }
        
        @Override
        public void onStop(){
        	super.onStop();
    		Log.d(TAG,"Fragment-onStop");
        }
        
        @Override
        public void onDestroyView(){
        	super.onDestroyView();
    		Log.d(TAG,"Fragment-onDestroyView");
        }
        
        @Override
        public void onDestroy(){
        	super.onDestroy();
    		Log.d(TAG,"Fragment-onDestroy");
        }
        
        @Override
        public void onDetach(){
        	super.onDetach();
    		Log.d(TAG,"Fragment-onDetach");
        }


		@Override
		public void onClick(View v) {
	        Fragment newFragment = new DownFragment();

	        // Add the fragment to the activity, pushing this transaction
	        // on to the back stack.
	        FragmentTransaction ft = getFragmentManager().beginTransaction();
	        ft.replace(R.id.fragment02, newFragment);
	        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
	        ft.addToBackStack(null);
	        ft.commit();
			
		}
        
    }
    public static class DownFragment extends Fragment {
    	DownFragment(){
    	}
    	
    	@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	View v = inflater.inflate(R.layout.component_text,container,false);
        	
        	return v;
        }

    }

}