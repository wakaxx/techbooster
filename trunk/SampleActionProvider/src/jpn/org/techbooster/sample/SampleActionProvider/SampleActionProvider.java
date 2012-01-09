package jpn.org.techbooster.sample.SampleActionProvider;

import android.content.Context;
import android.view.ActionProvider;
import android.view.View;
import android.widget.Toast;

public class SampleActionProvider extends ActionProvider{

    private Context mContext;
    
    public SampleActionProvider(Context context) {
	super(context);
	this.mContext = context;
    }

    @Override
    public View onCreateActionView() {
	return null;
    }
    
    @Override
    public boolean onPerformDefaultAction() {
	Toast.makeText(mContext, "onPerformDefaultAction", Toast.LENGTH_SHORT).show();
        return super.onPerformDefaultAction();
    }

}
