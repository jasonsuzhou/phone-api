package com.xuya.charge.phone.domain.model.customer;

/**
 * This is domain value object
 * 
 * @author Jason
 *
 */
public class Client {

	private Long id;
	private String secret;
	
	public Client(Long id, String secret) {
		this.id = id;
		this.secret = secret;
	}

	public Long getId() {
		return id;
	}

	public String getSecret() {
		return secret;
	}

}
