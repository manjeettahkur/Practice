package com.snapdeal.twitterClient.fetchBE;

import java.util.List;

import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.snapdeal.cassendraclient.Executer;
import com.snapdeal.cassendraclient.impl.CassandraExecuter;
import com.snapdeal.other.SDUtils;

public class DataReader {
	static Executer executer = new CassandraExecuter();
	
	public  String getTotalTweet(String source) {
		
		return "";
	}

	public  String getMostRetweetedTweet(String source, long currentDate, long prevDate) {

		String parentId = null;
		Long parentTime = null;
		Long maxCount = new Long(0);
		Statement select = QueryBuilder
				.select()
				.column("parent_id")
				.column("parent_time")
				.column("rt_count")
				.from("snapdeal_twitter", "retweet_counter")
				.where(QueryBuilder.eq("source", source))
				.and(QueryBuilder.gte("rt_time",
						SDUtils.getHourEpochTime(prevDate)))
				.and(QueryBuilder.lte("rt_time",
						SDUtils.getHourEpochTime(currentDate)));

		ResultSet rs = executeQuery(select.toString());
		for (Row row : rs) {
			if (maxCount < row.getLong("rt_count")) {
				parentId = row.getString("parent_id");
				maxCount = row.getLong("rt_count");
				parentTime = row.getDate("parent_time").getTime();
			}
		}

		if (parentId == null) {
			return "";
		}
		
		return getTweetDetails(source, parentId, parentTime, maxCount).toString();

	}

	private JSONObject getTweetDetails(String source, String parentId, Long parentTime,Long rt_count) {
		Statement select = QueryBuilder.select().all()
				.from("snapdeal_twitter", "tweet_details")
				.where(QueryBuilder.eq("source", source))
				.and(QueryBuilder.eq("creation_time", parentTime))
				.and(QueryBuilder.eq("tweet_id", parentId));

		ResultSet rs = executeQuery(select.toString());
		JSONObject tweetObj = new JSONObject();
		for (Row row : rs) {
			try {
				tweetObj.put("tweet", row.getString("tweet"));
				tweetObj.put("time", row.getDate("creation_time"));
				tweetObj.put("total_retweet", row.getInt("retweet_count"));
				tweetObj.put("retweet_thisHour",rt_count);

				if (row.getString("location") != null) {
					tweetObj.put("location", row.getString("location"));
				} else {
					tweetObj.put("location", "");
				}
				List<String> hashTags=row.getList("hashtag", String.class);
				JSONArray hashTagsArray=new JSONArray();
				
				for (String string : hashTags) {
					JSONObject hashtagObj=new JSONObject();
					hashtagObj.put("hashtag",string);
					hashTagsArray.put(hashtagObj);
				}
				tweetObj.put("hashtags", hashTagsArray);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return tweetObj;
	}

	private ResultSet executeQuery(String query) {

		// System.out.println(query);
		ResultSet rs = executer.execute(query);
		return rs;
	}

}
