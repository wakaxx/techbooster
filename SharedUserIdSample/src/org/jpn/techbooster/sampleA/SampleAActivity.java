package org.jpn.techbooster.sampleA;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;

public class SampleAActivity extends Activity {
	static final String DB = "sqlite_sample.db"; // データベース名
	static final int DB_VERSION = 1; // データベースのバージョン
	static final String CREATE_TABLE = "create table mytable ( _id integer primary key autoincrement, data integer not null );"; // テーブル作成用SQL文
	static final String DROP_TABLE = "drop table mytable;"; // テーブル削除用SQL文

	static SQLiteDatabase mydb;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Context mContext = null;
		// Contextの取得
		try {
			mContext = this.createPackageContext(
					"org.jpn.techbooster.SQLiteSample",
					Context.CONTEXT_RESTRICTED);

			MySQLiteOpenHelper hlpr = new MySQLiteOpenHelper(mContext);
			mydb = hlpr.getWritableDatabase();

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		Cursor cursor = mydb.query("mytable", new String[] { "_id", "data" },
				null, null, null, null, "_id DESC");
		startManagingCursor(cursor);

		cursor.moveToFirst();
		String newId = cursor.getString(0);
		String newData = cursor.getString(1);

		TextView mTextView = (TextView) findViewById(R.id.textview1);
		mTextView.setText("get from" + mContext.getPackageName() + "\n"
				+ " DB data -> [" + newId + "] [" + newData + "]");

	}

	private static class MySQLiteOpenHelper extends SQLiteOpenHelper {
		// データベースが存在しない状態でデータベースをオープンしようとするとonCreateが呼ばれる
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_TABLE);
		}

		// onUpgradeでテーブル構造の再構成などの処理を行う
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL(DROP_TABLE);
			onCreate(db);
		}

		public MySQLiteOpenHelper(Context c) {
			super(c, DB, null, DB_VERSION);
		}
	}
}