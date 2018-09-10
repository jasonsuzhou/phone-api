package com.xuya.charge.phone.intf.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QueryOrderResultCommand {

	@NotNull(message = "client id cannot be empty")
	private Long cid;
	@NotNull(message = "order id cannot be empty")
	private String orderid;
	@NotBlank(message = "sign cannot be empty")
	private String sign;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
