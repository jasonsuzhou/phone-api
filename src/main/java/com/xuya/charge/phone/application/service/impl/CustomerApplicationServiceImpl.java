package com.xuya.charge.phone.application.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuya.charge.phone.application.exception.ApplicationException;
import com.xuya.charge.phone.application.service.CustomerApplicationService;
import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.domain.repository.ICustomerRepository;
import com.xuya.charge.phone.infra.util.SummaryUtils;
import com.xuya.charge.phone.intf.dto.QueryBalanceCommand;

@Service
public class CustomerApplicationServiceImpl implements CustomerApplicationService {
	
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public BigDecimal currentBalance(QueryBalanceCommand command) throws ApplicationException {
		Long customerId = command.getCid();
		String secret = customerRepository.queryClientSecret(customerId);
		checkQueryBalanceRequest(customerId,secret,command.getSign());
		return customerRepository.currentBalance(customerId);
	}
	
	public void checkQueryBalanceRequest(Long customerId, String secret, String sign) throws ApplicationException {
		String signString = customerId + secret;
		String newSign = SummaryUtils.getMD5Summary(signString);
		if (!newSign.equalsIgnoreCase(sign)) {
			throw new ApplicationException(ReturnCode.SIGN_INCORRECT,"sign not correct");
		}
	}
	
}
