package org.japan.techbooster.sample.ObjectIntentSample;

import java.io.Serializable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import org.japan.techbooster.sample.ObjectIntentSample.TestResults.*;

public class RecieveActiviity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        
        TextView eng = (TextView)findViewById(R.id.eng_tv);
        TextView math = (TextView)findViewById(R.id.math_tv);
        TextView science = (TextView)findViewById(R.id.science_tv);
        TextView social = (TextView)findViewById(R.id.social_tv);
        
        TestResults tr = (TestResults)getIntent().getSerializableExtra("test_result");
//        TestResults tr = (TestResults)getIntent().getParcelableExtra("test_result");
        eng.setText(String.valueOf(tr.getPoint(subject.ENGLISH)));
        math.setText(String.valueOf(tr.getPoint(subject.MATHEMATICS)));
        science.setText(String.valueOf(tr.getPoint(subject.SCIENTICS)));
        social.setText(String.valueOf(tr.getPoint(subject.SOCIETY)));        
    }
}
