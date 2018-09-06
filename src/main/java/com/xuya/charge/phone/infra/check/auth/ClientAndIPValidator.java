package com.xuya.charge.phone.infra.check.auth;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.xuya.charge.phone.infra.cache.guava.ClientCache;
import com.xuya.charge.phone.infra.cache.guava.WhiteIPCache;

@Component
public class ClientAndIPValidator {
	
	public String isValid(String cid, String ip) {
		if (StringUtils.isBlank(cid)) {
			return "client id is not valid";
		}
		if (StringUtils.isBlank(ClientCache.get(cid))) {
			return "client id is not valid";
		} else {
			String ips = WhiteIPCache.get(cid);
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
