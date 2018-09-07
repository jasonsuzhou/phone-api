package com.xuya.charge.phone.infra.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class ConfigCache {
	public static final String MAINTAIN_KEY = "config:maintain";
	public static final String MAINTAIN_VALUE_FALSE = "0";
	public static final String MAINTAIN_VALUE_TRUE = "1";
	private static Cache<String, String> cache = CacheBuilder.newBuilder().build();
	
	static {
		cache.put("config:maintain", MAINTAIN_VALUE_TRUE);
	}

	public static void put(String key, String value) {
		cache.put(key, value);
	}

	public static String get(String key) {
		return cache.getIfPresent(key);
	}
}
