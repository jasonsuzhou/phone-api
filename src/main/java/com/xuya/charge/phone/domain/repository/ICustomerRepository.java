package com.xuya.charge.phone.domain.repository;

import java.math.BigDecimal;

public interface ICustomerRepository {

	BigDecimal currentBalance(Long customerId);

	String queryClientSecret(Long customerId);
	
}
