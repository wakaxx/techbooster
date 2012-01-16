package jp.org.techbooster.db;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DBShowActivity extends Activity implements OnClickListener {
	// DB周りの宣言
	private SQLiteDatabase mydb;

	private EditText serchNum;
	private Button serchButton;
	private Button deleteButton;
	private TextView showField;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_activity);

		// Viewの設定
		serchNum = (EditText) findViewById(R.id.SerchNum);
		serchButton = (Button) findViewById(R.id.SerchButton);
		serchButton.setOnClickListener(this);
		deleteButton = (Button) findViewById(R.id.DeleteButton);
		deleteButton.setOnClickListener(this);
		showField = (TextView) findViewById(R.id.text_field);

		// DBの作成
		MySQLiteOpenHelper hlpr = new MySQLiteOpenHelper(
				getApplicationContext(), DBSampleActivity.CREATE_TABLE_SQL);
		mydb = hlpr.getWritableDatabase();
	}

	@Override
	public void onClick(View v) {
		int rgex = Integer.parseInt(serchNum.getText().toString());

		switch (v.getId()) {
		case R.id.SerchButton:
			/* 検索の処理 */
			// queryを使用
			// query(table名,field名(String[]),検索語,WHERE句,GROUP BY，HAVING，ORDER
			// BY)
			Cursor mCursor = mydb.query(DBSampleActivity.TABLE_NAME,
					new String[] { DBSampleActivity.FIELD_ID,
							DBSampleActivity.FIELD_DATA }, DBSampleActivity.FIELD_ID+"=?"
							, new String[]{serchNum.getText().toString()}, null, null, null);

			// rawQueryを使用
			// String SQL_SELECT = "SELECT " + DBSampleActivity.FIELD_ID + ","
			// + DBSampleActivity.FIELD_DATA + " FROM "
			// + DBSampleActivity.TABLE_NAME + " WHERE "
			// + DBSampleActivity.FIELD_ID + "=" + rgex + ";";
			// selectionArgs : WHERE句を使用するときに指定する。
			// Cursor mCursor = mydb.rawQuery(SQL_SELECT, null);

			// Cursorを先頭に移動する 検索結果が0件の場合にはfalseが返る
			if (mCursor.moveToFirst()) {
				String text = mCursor.getString(mCursor
						.getColumnIndex(DBSampleActivity.FIELD_DATA));

				// TextViewに表示する
				showField.setText(text);
			} else {
				// 検索結果が無いのでTextViewをクリアする
				showField.setText(null);

			}

			break;
		case R.id.DeleteButton:
			mydb.delete(DBSampleActivity.TABLE_NAME, DBSampleActivity.FIELD_ID
					+ "=?", new String[] { serchNum.getText().toString() });
			Toast.makeText(this, "DELETE KEY[" + rgex + "]", Toast.LENGTH_LONG)
					.show();

			break;
		default:
			break;
		}

	}

}
