package com.snapdeal.twitterClient.DataInjector;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import twitter4j.JSONException;
import twitter4j.JSONObject;

public class TwitterStreamConsumer extends Thread{

	String tracker=null;
	public TwitterStreamConsumer(String tracker) {
		this.tracker=tracker;
	}
	
	private static final String STREAM_URI = "https://stream.twitter.com/1.1/statuses/filter.json";
	static String AccessToken = "88337638-w4GAyhkXfjS7Mwo7BQuHxIV0acKrhJWqFNMw9mwN8";
	static String AccessSecret = "ZbWj6nRh6IOt28ukots99OudXod84MfFULybReZtNYKIX";
	static String ConsumerKey = "m3n6oKzYWYgy80e9978JRiYC7";
	static String ConsumerSecret = "kMPcKwRHMaWrgSIwfw9LWCFY9wKYjWBP6Ds326schdrmOZIiQn";
	TwitterDataWriter tdatawriter=new TwitterDataWriter();
	
	
		public void run() {
			//CassandraExecuter executor=new CassandraExecuter();
		
			System.out.println("starting Consumer Thread for "+tracker);
			try
			{
				OAuthService service=new ServiceBuilder()
				.provider(TwitterApi.class)
				.apiKey(ConsumerKey)
				.apiSecret(ConsumerSecret)
				.build();
				
				Token accessToken=new Token(AccessToken, AccessSecret);
				OAuthRequest request=new OAuthRequest(Verb.POST, STREAM_URI);
				
				request.addHeader("version", "HTTP/1.1");
	            request.addHeader("host", "stream.twitter.com");
	            request.setConnectionKeepAlive(true);
	            request.addHeader("user-agent", "Twitter Stream Reader");
	            request.addBodyParameter("track", tracker); 
	            service.signRequest(accessToken, request);
	            Response response = request.send();
	            
	            BufferedReader br=new BufferedReader(new InputStreamReader(response.getStream()));
	            String line;
	            while ((line = br.readLine()) != null) {
	                //System.out.println(line);
	                
	            	try
	            	{
	            		//System.out.println(line);
	            		JSONObject jobj=new JSONObject(line);
		                tdatawriter.writeData(jobj,tracker);
	            		//System.out.println(jobj.toString());
	            	}
	                catch(JSONException e)
	            	{	
	                	//e.printStackTrace();
	                
	                	System.out.println("error"+line);
	            	}
	            }
	            System.out.println("exiting");
			}
		catch(Exception e)
			{
			System.out.println("sdsds");
			e.printStackTrace();
			}
			
		}
		 
	
	
}
