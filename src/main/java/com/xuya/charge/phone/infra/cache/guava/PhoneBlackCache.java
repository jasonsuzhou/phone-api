package com.xuya.charge.phone.infra.cache.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class PhoneBlackCache {
	private static Cache<String, String> cache = CacheBuilder.newBuilder().build();

	public static void put(String key, String value) {
		cache.put(key, value);
	}

	public static String get(String key) {
		return cache.getIfPresent(key);
	}
}
