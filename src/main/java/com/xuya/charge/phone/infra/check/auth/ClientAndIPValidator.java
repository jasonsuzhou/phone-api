package com.xuya.charge.phone.infra.check.auth;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xuya.charge.phone.infra.cache.CacheKeys;
import com.xuya.charge.phone.infra.cache.guava.ClientCache;

@Component
public class ClientAndIPValidator {
	
	@Autowired
	StringRedisTemplate authInfoStringRedisTemplate;
	
	public String isValid(String cid, String ip) {
		if (StringUtils.isBlank(cid)) {
			return "client id is not valid";
		}
		String authInfo = authInfoStringRedisTemplate.opsForValue().get(CacheKeys.getAuthClientKey(cid));
		if (StringUtils.isBlank(authInfo)) {
			return "client id is not valid";
		} else {
			// {"secret":"xx","ips":"xx"}
			JSONObject json = JSON.parseObject(authInfo);
			String secret = json.getString("secret");
			ClientCache.put(cid, secret);
			String ips = json.getString("ips");
			if (StringUtils.isNotBlank(ips)) {
				boolean valid = isValidIP(ips, ip);
				if (!valid) {
					return "ip address is not valid";
				}
			}
		}
		return null;
	}
	
	private boolean isValidIP(String ips, String ip) {
		// default true if we did not configure the white ip
		if (StringUtils.isBlank(ips)) {
			return true;
		}
		boolean isValid = true;
		if (ips.contains(",")) {
			String[] ipArray = ips.split(",");
			List<String> ipList = Arrays.asList(ipArray);
			isValid = ipList.contains(ip);
		} else {
			isValid = ips.equals(ip);
		}
		return isValid;
	}

}
