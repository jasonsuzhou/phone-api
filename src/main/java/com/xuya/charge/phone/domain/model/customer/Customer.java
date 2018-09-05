package com.xuya.charge.phone.domain.model.customer;

import java.math.BigDecimal;

/**
 * This is domain entity, also this is aggregate/root entity
 * 
 * @author Jason
 *
 */
public class Customer {

	private Long id;
	private BigDecimal balance;
	private Client client;
	private WhiteIP whiteIP;
	
	public Customer(Long id) {
		this.setId(id);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public WhiteIP getWhiteIP() {
		return whiteIP;
	}

	public void setWhiteIP(WhiteIP whiteIP) {
		this.whiteIP = whiteIP;
	}
	
}
