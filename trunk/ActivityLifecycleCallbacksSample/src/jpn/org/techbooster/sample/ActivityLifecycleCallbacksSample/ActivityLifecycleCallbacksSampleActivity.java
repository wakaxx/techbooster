package jpn.org.techbooster.sample.ActivityLifecycleCallbacksSample;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class ActivityLifecycleCallbacksSampleActivity extends Activity {
    private static ActivityLifecycleCallbacksSampleActivity mInstance = new ActivityLifecycleCallbacksSampleActivity();
    private ActivityLifecycleCallbacks mCallbacks;

    public static ActivityLifecycleCallbacksSampleActivity getInstance() {
        return mInstance;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
         CatchCallBackFragment fragment = new CatchCallBackFragment();
         this.setActivityLifecycleCallbacks(fragment);
         FragmentTransaction ft = getFragmentManager().beginTransaction();
         ft.add(R.id.fragment_space, fragment);
         ft.commit();
        
        if(mCallbacks != null && savedInstanceState != null){
            mCallbacks.onActivityCreated(this, savedInstanceState);
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mCallbacks != null){
            mCallbacks.onActivityDestroyed(this);
        }
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        
        if(mCallbacks != null){
            mCallbacks.onActivityPaused(this);
        }
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        
        if(mCallbacks != null){
            mCallbacks.onActivityResumed(this);
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
        if(mCallbacks != null){
            mCallbacks.onActivitySaveInstanceState(this, outState);
        }
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        
        if(mCallbacks != null){
            mCallbacks.onActivityStarted(this);
        }
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        
        if(mCallbacks != null){
            mCallbacks.onActivityStopped(this);
        }
    }

    public void setActivityLifecycleCallbacks(
            ActivityLifecycleCallbacks callbacks) {
        this.mCallbacks = callbacks;
    }
}