package com.xuya.charge.phone.infra.dao;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xuya.charge.phone.domain.repository.ICustomerRepository;
import com.xuya.charge.phone.infra.cache.guava.ClientCache;

@Repository
public class CustomerRepository implements ICustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BigDecimal currentBalance(Long customerId) {
		String sql = "select balance from proxy_customer where id=" + customerId;
		return jdbcTemplate.queryForObject(sql, BigDecimal.class);
	}
	
	@Override
	public String queryClientSecret(Long customerId) {
		String secret = ClientCache.get(String.valueOf(customerId));
		if (StringUtils.isBlank(secret)) {
			secret = querySecret(customerId);
		}
		return secret;
	}

	private String querySecret(Long customerId) {
		String sql = "select secret from sys_client where id=" + customerId;
		return jdbcTemplate.queryForObject(sql, String.class);
	}

}
