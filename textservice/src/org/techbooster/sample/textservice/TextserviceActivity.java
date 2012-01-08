package org.techbooster.sample.textservice;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextserviceActivity extends Activity {
	SpellCheckerSession session;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final TextView tv = (TextView) findViewById(R.id.textView1);

		TextServicesManager manager = (TextServicesManager) getSystemService(TEXT_SERVICES_MANAGER_SERVICE);

		session = manager.newSpellCheckerSession(null, Locale.ENGLISH,
				new SpellCheckerSessionListener() {
					public void onGetSuggestions(SuggestionsInfo[] results) {
						for (SuggestionsInfo result : results) {
							if (result.getSuggestionsCount() <= 0) {
								tv.setText("no suggestions");
							} else {

								tv.setText("did you mean "
										+ result.getSuggestionAt(0) + "?");
							}
						}
					}
				}, false);

		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText et = (EditText) findViewById(R.id.editText1);
				session.getSuggestions(new TextInfo(et.getText().toString()),
						10);
				session.close();
			}
		});
	}
}