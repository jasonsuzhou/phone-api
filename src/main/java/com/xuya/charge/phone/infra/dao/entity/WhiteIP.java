package com.xuya.charge.phone.infra.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_client_white_ip")
public class WhiteIP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5082037483733108270L;
	@Id
	private Long id;
	@Column(length=256,nullable=true)
	private String ips;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

}
