package com.snapdeal.twitterClient.DataInjector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import twitter4j.JSONArray;
import twitter4j.JSONException;
import twitter4j.JSONObject;

public class HashTagrends {

	static MaxSizeHashMap<String, HashMap<String, Integer>> hm = new MaxSizeHashMap<String, HashMap<String, Integer>>(
			5);

	void addHashTag(List<String> hashTags, String timestamp) {
		if (hm.containsKey(timestamp)) {
			for (String hashtag : hashTags) {
				hm.put(timestamp, insertHashTag(hashtag, hm.get(timestamp)));
			}

		} else {
			HashMap<String, Integer> hashTagMap = new HashMap<String, Integer>();
			hm.put(timestamp, hashTagMap);
			for (String hashTag : hashTags) {
				hm.put(timestamp, insertHashTag(hashTag, hm.get(timestamp)));
			}
		}
	}

	private HashMap<String, Integer> insertHashTag(String hashTag,
			HashMap<String, Integer> hashTagMap) {
		if (hashTagMap.containsKey(hashTag)) {
			hashTagMap.put(hashTag, hashTagMap.get(hashTag) + 1);
		} else {
			hashTagMap.put(hashTag, 1);
		}
		return hashTagMap;

	}
	
	
	public JSONArray getTrendingHashTags(String timestamp)
	{
		JSONArray hashTags=new JSONArray();
		HashMap<String, Integer> trendThisMinute=hm.get(timestamp);
		for (String hashtag : trendThisMinute.keySet()) {
			JSONObject jobj=new JSONObject();
			try {
				jobj.put("hashTag", hashtag);
				jobj.put("counter", trendThisMinute.get(hashtag));
				hashTags.put(jobj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return hashTags;
	}

}
