package com.jslsolucoes.tagria.tag.base.tag;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CacheService {

	private static final Cache<String, String> cache = CacheBuilder.newBuilder().build();
	
	public static String value(String key) {
		return cache.getIfPresent(key);
	}
	
	public static void put(String key,String value) {
		cache.put(key, value);
	}
}
