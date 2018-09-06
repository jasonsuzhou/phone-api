package com.xuya.charge.phone.domain.model.customer;

import java.math.BigDecimal;

import com.xuya.charge.phone.domain.repository.ICustomerRepository;

/**
 * This is domain entity, also this is aggregate/root entity
 * 
 * @author Jason
 *
 */
public class Customer {

	private ICustomerRepository customerRepository;
	
	private Long id;
	private BigDecimal balance;
	private Client client;
	
	public Customer(Long id, ICustomerRepository customerRepository) {
		this.setId(id);
		this.customerRepository = customerRepository;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		this.balance = this.customerRepository.currentBalance(this.id);
		return this.balance;
	}

	public Client getClient() {
		String secret = this.customerRepository.queryClientSecret(this.id);
		this.client = new Client(this.id, secret);
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
