package org.jpn.techbooster.sample.ContentResolverActivity;

import android.app.Activity;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
//import android.provider.Contacts.People;
import android.widget.TextView;

public class ContentResolverActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        //クエリ(データを取り出すための操作)を作る
        Cursor cursor = managedQuery(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        //カーソルを移動(レコードの先頭に)
        cursor.moveToFirst();
        int fieldIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID);
        Long id = cursor.getLong( fieldIndex );

        //カーソルを閉じる
        cursor.close();


        //ContentUrisメソッドを使ってベースとなるURIとIDから該当レコードのUriを生成します
        Uri person = ContentUris.withAppendedId(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, id);

        //引数の与え方が異なりますがUriメソッドを使っても同様のことが可能です
        //Uri person = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, String.valueOf(id) );

        //レコードを取得するカーソル作成
        cursor = managedQuery(person, null, null, null, null);

        //ContentsResolverを利用してカーソルを取得する方法
        //cursor = getContentResolver().query( ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ id, null, null);

        cursor.moveToFirst();

        //フィールド名を取り出す。今回は名前がdisplay_nameのカラムのインデックスを取得。
        String displayName = ContactsContract.CommonDataKinds.Phone.NUMBER;
        fieldIndex = cursor.getColumnIndex(displayName);

        //先頭IDのユーザー名を取得
        String name = cursor.getString(fieldIndex);
        cursor.close();

        TextView tv = (TextView)findViewById(R.id.username);
        tv.setText(name);

    }
}