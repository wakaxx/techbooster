package org.jpn.techbooster.SQLiteSample;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SQLiteSample extends Activity implements OnClickListener {
	static final String DB = "sqlite_sample.db"; // データベース名
	static final int DB_VERSION = 1; // データベースのバージョン
	static final String CREATE_TABLE = "create table mytable ( _id integer primary key autoincrement, data integer not null );"; // テーブル作成用SQL文
	static final String DROP_TABLE = "drop table mytable;"; // テーブル削除用SQL文

	static SQLiteDatabase mydb;

	private SimpleCursorAdapter myadapter;

	private ListView listview;
	private Button addbtn, delbtn;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// SQLiteOpenHelperを使ってデータベースをオープンする
		MySQLiteOpenHelper hlpr = new MySQLiteOpenHelper(getApplicationContext());
		mydb = hlpr.getWritableDatabase();

		Cursor cursor = mydb.query("mytable", new String[] { "_id", "data" },	null, null, null, null, "_id DESC");
		String[] from = new String[] { "_id", "data" };
		int[] to = new int[] { R.id._id, R.id.data };
		myadapter = new SimpleCursorAdapter(this, R.layout.db_data, cursor, from, to);

		listview = (ListView) findViewById(R.id.ListView);
		listview.setAdapter(myadapter);

		addbtn = (Button) findViewById(R.id.Add);
		addbtn.setOnClickListener(this);
		delbtn = (Button) findViewById(R.id.Delete);
		delbtn.setOnClickListener(this);
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

	public void onClick(View view) {
		// 行の追加を行う
		if (view.getId() == R.id.Add) {
			ContentValues values = new ContentValues();
			values.put("data", "data");
			mydb.insert("mytable", null, values);

			Cursor cursor = mydb.query("mytable", new String[] { "_id", "data" }, null, null, null, null, "_id DESC");
			startManagingCursor(cursor);
			myadapter.changeCursor(cursor);

		// 行の削除を行う
		} else if (view.getId() == R.id.Delete) {
			mydb.delete("mytable", "_id like '%'", null);
			Cursor cursor = mydb.query("mytable", new String[] { "_id", "data" }, null, null, null, null,	"_id DESC");
			startManagingCursor(cursor);
			myadapter.changeCursor(cursor);
		}
	}
}
