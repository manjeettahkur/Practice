package com.snapdeal.twitterClient.DataInjector;

public class LocTweet {
	String text;
	String location;
	public LocTweet(String text, String location) {
		super();
		this.text = text;
		this.location = location;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return location;
	}
	
	
	
}
