package com.xuya.charge.phone.infra.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SummaryUtils {
	
	public static String getMD5Summary(String source) {
		return DigestUtils.md5Hex(source);
	}

	public static String getSHA1Summary(String sourrce) {
		return DigestUtils.sha1Hex(sourrce);
	}
}
