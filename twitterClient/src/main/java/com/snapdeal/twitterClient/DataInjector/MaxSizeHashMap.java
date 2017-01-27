package com.snapdeal.twitterClient.DataInjector;

import java.util.LinkedHashMap;

public class MaxSizeHashMap<K,V> extends LinkedHashMap<K, V> {
	
	private final int maxSize;

	public MaxSizeHashMap(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size()>maxSize;
	}
	
	
	
	

}
