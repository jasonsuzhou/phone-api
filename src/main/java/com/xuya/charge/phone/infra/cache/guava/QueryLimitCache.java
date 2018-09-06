package com.xuya.charge.phone.infra.cache.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class QueryLimitCache {
	
	private static Cache<String, String> cache = CacheBuilder.newBuilder()
			.expireAfterWrite(30, TimeUnit.SECONDS)
			.build();
	
	public static void put(String key, String value) {
		cache.put(key, value);
	}
	
	public static String get(String key) {
		return cache.getIfPresent(key);
	}

}
