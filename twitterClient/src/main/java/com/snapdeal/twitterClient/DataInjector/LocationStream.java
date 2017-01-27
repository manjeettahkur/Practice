package com.snapdeal.twitterClient.DataInjector;

import java.util.Queue;

import twitter4j.JSONException;
import twitter4j.JSONObject;

import com.google.common.collect.EvictingQueue;

public class LocationStream {
	 static Queue<LocTweet> locStream=null;
	
	public LocationStream() {
	locStream=EvictingQueue.create(20);	
	}
	
	void addTweet(JSONObject json) throws JSONException
	{
		
		if(json.getJSONObject("user").getString("location")!=null)
		{
			locStream.add(new LocTweet(json.getString("text"), json.getJSONObject("user").getString("location")));
		}
		
		
	}
	
	void getTweet()
	{
		
		System.out.println(locStream.toString());
	}
	
	
}
