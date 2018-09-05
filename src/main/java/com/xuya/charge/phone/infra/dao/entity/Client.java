package com.xuya.charge.phone.infra.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3085537859908391584L;

	@Id
	private long id;
	@Column(nullable = false, length = 32)
	private String secret;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
