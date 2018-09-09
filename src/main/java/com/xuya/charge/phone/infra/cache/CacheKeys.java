package com.xuya.charge.phone.infra.cache;

public class CacheKeys {
	public static final String MAINTAIN_KEY = "apicenter:maintain:0";
	public static final String AUTH_CLIENT_KEY_PREFIX = "apicenter:auth:0:";
	public static final String PHONE_BLACK_KEY_PREFIX = "black:0:";
	
	public static String getAuthClientKey(String cid) {
		return AUTH_CLIENT_KEY_PREFIX + cid;
	}

	public static String getPhoneBlackKey(String phone) {
		return PHONE_BLACK_KEY_PREFIX + phone;
	}
}
