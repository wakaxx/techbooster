package org.jpn.techbooster.sample.OauthSample5;

import java.util.ArrayList;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class TimelineActivity extends ListActivity{
	private Twitter _tw;
	private ArrayList<Status> _tweet_id_list;
	private int _selected_position = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = getTimeline();
		if(adapter != null){
			setListAdapter(adapter);
		}
		
		registerForContextMenu(getListView());
	}
	
	private ArrayAdapter<String> getTimeline(){
		SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
		String token = sp.getString("token", "");
		String tokenSecret = sp.getString("token_seacret", "");
		
		//twitterオブジェクトの作成
		_tw = new TwitterFactory().getInstance();
		
		//AccessTokenオブジェクトの作成
		AccessToken at = new AccessToken(token, tokenSecret);
		
		//Consumer keyとConsumer key seacretの設定
		_tw.setOAuthConsumer("iy2FEHXmSXNReJ6nYQ8FRg", "KYro4jM8BHlLSMsSdTylnTcm3pYaTCiG2UZrYK1yI4");
		
		//AccessTokenオブジェクトを設定
		_tw.setOAuthAccessToken(at);
		
		try {
			//TLの取得
			ResponseList<Status> homeTl = _tw.getHomeTimeline();
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
			_tweet_id_list = new ArrayList<Status>();
			
			for (Status status : homeTl) {
				//つぶやきのユーザーIDの取得
				String userName = status.getUser().getScreenName();
				//つぶやきの取得
				String tweet = status.getText();
				adapter.add("ユーザーID：" + userName + "\r\n" + "tweet：" + tweet);
				//つぶやきを保存
				_tweet_id_list.add(status);
			}
			
			return adapter;
		} catch (TwitterException e) {
			e.printStackTrace();
			if(e.isCausedByNetworkIssue()){
				Toast.makeText(getApplicationContext(), "ネットワークに接続して下さい", Toast.LENGTH_LONG);
			}else{
				Toast.makeText(getApplicationContext(), "エラーが発生しました。", Toast.LENGTH_LONG);
			}
		}
		return null;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
		//タップ位置の取得
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)menuInfo;
		_selected_position = info.position;
		
		menu.setHeaderTitle("メニュー");
		menu.add("リツイート");
		menu.add("お気に入り");
		menu.add("DM");
		menu.add("フォロー");
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		try {
			
			//Follow
			_tw.destroyFriendship("k_ikata_and_dev");
			
			//DM送信
			_tw.sendDirectMessage(_tweet_id_list.get(_selected_position).getUser().getId(), "てすてす");
			
			//お気に入り
			_tw.destroyFavorite(_tweet_id_list.get(_selected_position).getId());
			
			//リツイート
			_tw.retweetStatus(_tweet_id_list.get(_selected_position).getId());
			
			//相手がFollowしているかを判定
			Toast.makeText(this, String.valueOf(_tweet_id_list.get(_selected_position).getUser().isFollowRequestSent()), Toast.LENGTH_LONG).show();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return super.onContextItemSelected(item);
	}
}
