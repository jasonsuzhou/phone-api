package com.xuya.charge.phone.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuya.charge.phone.domain.repository.ICustomerRepository;

@Service
public class CustomerDomainService {
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	public String getClientSecret(Long customerId) {
		return customerRepository.queryClientSecret(customerId);
	}

}
