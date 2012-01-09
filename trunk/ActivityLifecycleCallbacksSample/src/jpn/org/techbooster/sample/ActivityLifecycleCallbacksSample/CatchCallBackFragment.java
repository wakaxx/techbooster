package jpn.org.techbooster.sample.ActivityLifecycleCallbacksSample;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

public class CatchCallBackFragment extends Fragment implements ActivityLifecycleCallbacks{
    
    public CatchCallBackFragment() {
    }
    
    public void addActivityCallbacks(){
        
    }

    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "onActivityCreated", Toast.LENGTH_LONG).show();
    }

    public void onActivityDestroyed(Activity activity) {
        Toast.makeText(getActivity(), "onActivityDestroyed", Toast.LENGTH_LONG).show();
    }

    public void onActivityPaused(Activity activity) {
        Toast.makeText(getActivity(), "onActivityPaused", Toast.LENGTH_LONG).show();
    }

    public void onActivityResumed(Activity activity) {
        Toast.makeText(getActivity(), "onActivityResumed", Toast.LENGTH_LONG).show();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Toast.makeText(getActivity(), "onActivitySaveInstanceState", Toast.LENGTH_LONG).show();
    }

    public void onActivityStarted(Activity activity) {
        Toast.makeText(getActivity(), "onActivityStarted", Toast.LENGTH_LONG).show();
    }

    public void onActivityStopped(Activity activity) {
        Toast.makeText(getActivity(), "onActivityStopped", Toast.LENGTH_LONG).show();
    }
}
