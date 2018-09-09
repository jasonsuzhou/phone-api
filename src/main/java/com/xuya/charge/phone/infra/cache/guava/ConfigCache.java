package com.xuya.charge.phone.infra.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class ConfigCache {
	
	public static final String MAINTAIN_VALUE_FALSE = "false";
	public static final String MAINTAIN_VALUE_TRUE = "true";
	private static Cache<String, String> cache = CacheBuilder.newBuilder().build();
	
	static {
		cache.put("apicenter:maintain:0", MAINTAIN_VALUE_TRUE);
	}

	public static void put(String key, String value) {
		cache.put(key, value);
	}

	public static String get(String key) {
		return cache.getIfPresent(key);
	}
}
