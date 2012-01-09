package org.jpn.techbooster.sample.OauthSample4;

import twitter4j.CursorSupport;
import twitter4j.IDs;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterResponse;
import twitter4j.auth.AccessToken;
import android.app.ListActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class TimelineActivity extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = getTimeline();
		if(adapter != null){
			setListAdapter(adapter);
		}
	}
	
	private ArrayAdapter<String> getTimeline(){
		SharedPreferences sp = getSharedPreferences("token", MODE_PRIVATE);
		String token = sp.getString("token", "");
		String tokenSecret = sp.getString("token_seacret", "");
		
		//twitterオブジェクトの作成
		Twitter tw = new TwitterFactory().getInstance();
		
		//AccessTokenオブジェクトの作成
		AccessToken at = new AccessToken(token, tokenSecret);
		
		//Consumer keyとConsumer key seacretの設定
		tw.setOAuthConsumer("iy2FEHXmSXNReJ6nYQ8FRg", "KYro4jM8BHlLSMsSdTylnTcm3pYaTCiG2UZrYK1yI4");
		
		//AccessTokenオブジェクトを設定
		tw.setOAuthAccessToken(at);
		
		try {
			//TLの取得
			ResponseList<Status> homeTl = tw.getHomeTimeline();
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
			
			for (Status status : homeTl) {
				//つぶやきのユーザーIDの取得
				String userName = status.getUser().getScreenName();
				//つぶやきの取得
				String tweet = status.getText();
				adapter.add("ユーザーID：" + userName + "\r\n" + "tweet：" + tweet);
			}
			Status s = homeTl.get(homeTl.size());
			Paging p = new Paging();
			p.setMaxId(s.getId());
			
			homeTl = null;
			homeTl = tw.getHomeTimeline(p);
			
			for (Status status : homeTl) {
				//つぶやきのユーザーIDの取得
				String userName = status.getUser().getScreenName();
				//つぶやきの取得
				String tweet = status.getText();
				adapter.add("ユーザーID：" + userName + "\r\n" + "tweet：" + tweet);
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
}
