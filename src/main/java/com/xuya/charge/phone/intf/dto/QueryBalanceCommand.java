package com.xuya.charge.phone.intf.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QueryBalanceCommand {

	@NotNull(message = "client id cannot be empty")
	private Long cid;
	@NotBlank(message = "sign cannot be empty")
	private String sign;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
