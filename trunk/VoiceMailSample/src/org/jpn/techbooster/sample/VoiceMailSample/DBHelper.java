package org.jpn.techbooster.sample.VoiceMailSample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.VoicemailContract;
import android.provider.VoicemailContract.Voicemails;

public class DBHelper extends SQLiteOpenHelper {

    private static final String _data_base_name = "voice_mail_sample.db";
    public static final String _table_name_Voicemails = "Voicemails";
    public static final String _table_name_Status = "Status";

    public DBHelper(Context context) {
	super(context, _data_base_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
	String query = "create table " + _table_name_Voicemails + "("
		+ Voicemails.DATE + " INTEGER, " + Voicemails.DURATION + " INTEGER, "
		+ Voicemails.HAS_CONTENT + " INTEGER, " + Voicemails.IS_READ
		+ " INTEGER, " + Voicemails.MIME_TYPE + " TEXT, " + Voicemails.NUMBER
		+ " TEXT, " + Voicemails.SOURCE_DATA + " TEXT, "
		+ Voicemails.SOURCE_PACKAGE + " TEXT);";
	db.execSQL(query);

	query = "create table " + _table_name_Status + "("
		+ VoicemailContract.Status.CONFIGURATION_STATE + " INTEGER, "
		+ VoicemailContract.Status.DATA_CHANNEL_STATE + " INTEGER, "
		+ VoicemailContract.Status.NOTIFICATION_CHANNEL_STATE
		+ " INTEGER, " + VoicemailContract.Status.SETTINGS_URI
		+ " TEXT, " + VoicemailContract.Status.SOURCE_PACKAGE
		+ " TEXT, " + VoicemailContract.Status.VOICEMAIL_ACCESS_URI
		+ " TEXT);";
	db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
