package com.snapdeal.twitterClient.REST;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import twitter4j.JSONException;
import twitter4j.JSONObject;

import com.snapdeal.other.SDUtils;
import com.snapdeal.twitterClient.DataInjector.HashTagrends;
import com.snapdeal.twitterClient.DataInjector.TwitterDataWriter;
import com.snapdeal.twitterClient.fetchBE.DataReader;



@RestController
@EnableAutoConfiguration
public class ClientAPI {
	
	@RequestMapping(value = "/Hashtags", method = RequestMethod.GET)
	public String getHashTagsThisMinute()
	{
		long prevtimestamp=System.currentTimeMillis()-2*60*1000;
		HashTagrends trends=TwitterDataWriter.getTrends();
		
		return trends.getTrendingHashTags(""+SDUtils.getMinuteEpochTime(prevtimestamp)).toString();
	}
	
	
	@RequestMapping(value = "/sentiment/{source}", method = RequestMethod.GET)
	public String getSentiment(@PathVariable("source") String source)
	{
		double flikartsent=Math.random()*5;
		double Snapdealsent=Math.random()*5;
		JSONObject senttObj=new JSONObject();
		try {
			senttObj.put("flipkartsent",flikartsent);
			senttObj.put("Snapdealsent",Snapdealsent);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return senttObj.toString();	
	}
	
	
	@RequestMapping(value = "/totalTweets/{source}", method = RequestMethod.GET)
	public String totalTweet(@PathVariable("source") String source)
	{
		return "";
	}
	
	
	@RequestMapping(value = "/trendingTweet/{source}", method = RequestMethod.GET)
	public String getTrendingTweet(@PathVariable("source") String source,@RequestParam("endDate") String endDate,@RequestParam("startDate") String startDate)
	{
		DataReader dr=new DataReader();
		if(endDate=="" || startDate=="")
		{
			Long currentDate=System.currentTimeMillis();
			Long prevDate=currentDate-60*1000*60;
			return dr.getMostRetweetedTweet(source,currentDate,prevDate );
		}		
		return dr.getMostRetweetedTweet(source, Long.parseLong(endDate), Long.parseLong(startDate));
	}

	
	
	
}
