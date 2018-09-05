package com.xuya.charge.phone.infra.check.auth;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xuya.charge.phone.infra.dao.ClientRepository;
import com.xuya.charge.phone.infra.dao.WhiteIPRepository;
import com.xuya.charge.phone.infra.dao.entity.Client;
import com.xuya.charge.phone.infra.dao.entity.WhiteIP;

@Component
public class ClientAndIPValidator {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private WhiteIPRepository whiteIPRepository;
	
	public String isValid(String cid, String ip) {
		if (StringUtils.isBlank(cid)) {
			return "client id is not valid";
		}
		Long clientId = Long.valueOf(cid);
		// TODO need get from cache
		Optional<Client> oclient = this.clientRepository.findById(clientId);
		if (!oclient.isPresent()) {
			return "client id is not valid";
		} else {
			// TODO need get from cache
			Optional<WhiteIP> owhiteIP = this.whiteIPRepository.findById(clientId);
			if (owhiteIP.isPresent()) {
				String ips = owhiteIP.get().getIps();
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
