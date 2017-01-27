package com.snapdeal.twitterClient.DataInjector;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import twitter4j.JSONException;
import twitter4j.JSONObject;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.snapdeal.cassendraclient.Executer;
import com.snapdeal.cassendraclient.impl.CassandraExecuter;
import com.snapdeal.other.SDUtils;

public  class TwitterDataWriter {

	static Executer executer = new CassandraExecuter();
	static final HashTagrends trends=new HashTagrends();
	static final LocationStream locStream=new LocationStream();
	
	void tweetQueryExecutor(JSONObject jobj,String tracker,List<String> hashtags)
	{
		try
		{
			
			String place=null;
			Insert stmt=QueryBuilder.insertInto("snapdeal_twitter", "tweet_details").value("source",tracker)
					.value("creation_time",new Date(jobj.getString("created_at")).getTime()).value("retweet_count", jobj.get("retweet_count"))
					.value("tweet_id",jobj.get("id_str"));
					stmt.value("language",jobj.get("lang") );
					stmt.value("tweet", jobj.get("text"));
					if((jobj.getJSONObject("user").getString("location")=="null")||(jobj.getJSONObject("user").getString("location")==null))
					{
						place="";
					}
					else
					{
						place=jobj.getJSONObject("user").getString("location");
					}
					
					
					//System.out.println(jobj.getString("id"));
					stmt.value("user", jobj.getJSONObject("user").getString("name"));
					stmt.value("location", place);
					stmt.value("hashtag",hashtags);
					
					executeQuery(stmt.toString());
			}
			catch(JSONException e)
			{
				e.printStackTrace();
			}
			
	}

	
	
	public static HashTagrends getTrends() {
		return trends;
	}



	void writeData(JSONObject jobj,String tracker)
	{
		
		
		try
		{
			List<String> hashtags=new LinkedList<String>();
			for(int i=0;i<jobj.getJSONObject("entities").getJSONArray("hashtags").length();i++)
			{
				String hashtag=jobj.getJSONObject("entities").getJSONArray("hashtags").getJSONObject(i).get("text").toString();
				hashtags.add(hashtag);
			}
			trends.addHashTag(hashtags, ((Long)SDUtils.getMinuteEpochTime(new Date(jobj.getString("created_at")).getTime())).toString());
			locStream.addTweet(jobj);
			
			if(jobj.has("retweeted_status"))
			{
				
				writeRetweet(jobj, tracker,hashtags);
				return;
			}
			tweetQueryExecutor(jobj, tracker,hashtags);
			
		}
		catch(JSONException e)
		{
			
		}
		
			
	}
	
	
	void retweetQueryExecutor(JSONObject jobj,String tracker)
	{
		try
		{
			
			Statement stmt=QueryBuilder.update("snapdeal_twitter", "retweet_counter")
					.with(QueryBuilder.incr("rt_count"))
					.where(QueryBuilder.eq("source", tracker))
					.and(QueryBuilder.eq("rt_time",
							SDUtils.getHourEpochTime(Long.parseLong(jobj.getString("timestamp_ms")))))
					.and(QueryBuilder.eq("parent_time",new Date(jobj.getJSONObject("retweeted_status").getString("created_at")).getTime()))
					.and(QueryBuilder.eq("parent_id",jobj.getJSONObject("retweeted_status").getString("id_str")))
					;
			executeQuery(stmt.toString());
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	void writeRetweet(JSONObject jobj,String tracker,List<String> hashtags)
	{
		System.out.println("retweet");
		retweetQueryExecutor(jobj, tracker);
		try
		{
			tweetQueryExecutor(jobj.getJSONObject("retweeted_status"), tracker,hashtags);
		}
		catch(JSONException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private ResultSet executeQuery(String query)
	{
		
		//	System.out.println(query);
		ResultSet rs=executer.execute(query);
		return rs;
	}

}
