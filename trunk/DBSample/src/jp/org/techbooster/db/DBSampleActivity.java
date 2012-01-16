package jp.org.techbooster.db;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DBSampleActivity extends Activity implements OnClickListener {
	// SQLiteの設定
	public static final String TABLE_NAME = "sample_table";
	public static final String FIELD_ID = "_id";
	public static final String FIELD_DATA = "data";
	public static final String CREATE_TABLE_SQL = "CREATE TABLE " + TABLE_NAME
			+ " ( " + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ FIELD_DATA + " TEXT NOT NULL );";
	private SQLiteDatabase mydb;

	// View
	EditText mEditText;
	Button writeButton, showButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Viewの設定
		mEditText = (EditText) findViewById(R.id.InputField);
		writeButton = (Button) findViewById(R.id.WriteButton);
		writeButton.setOnClickListener(this);
		showButton = (Button) findViewById(R.id.ShowButton);
		showButton.setOnClickListener(this);

		// DBの作成
		MySQLiteOpenHelper hlpr = new MySQLiteOpenHelper(
				getApplicationContext(), CREATE_TABLE_SQL);
		mydb = hlpr.getWritableDatabase();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ShowButton:
			// データ検索表示画面へ遷移
			Intent nextAct = new Intent(this,jp.org.techbooster.db.DBShowActivity.class);
			startActivity(nextAct);
			finish();
			break;
		case R.id.WriteButton:
			// データの追加
			ContentValues values = new ContentValues();
			values.put(FIELD_DATA, mEditText.getText().toString());
			Long inNum = mydb.insert(TABLE_NAME, null, values); // nullが入力された場合、"" を入力させる。
			Toast.makeText(this, "INPUT KEY["+inNum+"]", Toast.LENGTH_LONG).show();
			
			break;
		default:
			break;
		}

	}

}