package com.xuya.charge.phone.intf.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SubmitOrderCommand {
	@NotNull(message = "client id cannot be empty")
	private Long cid;
	@NotNull(message = "order no. cannot be empty")
	private String orderno;
	@NotNull(message = "phone cannot be empty")
	private String phone;
	@NotNull(message = "money cannot be empty")
	private String money;
	@NotNull(message = "pcode cannot be empty")
	private String pcode;
	@NotBlank(message = "sign cannot be empty")
	private String sign;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
