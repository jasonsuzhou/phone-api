package com.xuya.charge.phone.domain.model.customer;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * This is domain value object
 * @author Jason
 *
 */
public class WhiteIP {

	private Long id;
	private String ips;

	public WhiteIP(Long id, String ips) {
		this.id = id;
		this.ips = ips;
	}

	public boolean isValidIP(String ip) {
		// default true if we did not configure the white ip
		if (StringUtils.isBlank(this.ips)) {
			return true;
		}
		boolean isValid = true;
		if (this.ips.contains(",")) {
			String[] ipArray = ips.split(",");
			List<String> ipList = Arrays.asList(ipArray);
			isValid = ipList.contains(ip);
		} else {
			isValid = this.ips.equals(ip);
		}
		return isValid;
	}

	public Long getId() {
		return id;
	}

	public String getIps() {
		return ips;
	}

}
