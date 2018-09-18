package com.xuya.charge.phone.domain.model.order;

import java.util.Date;

public class Order {

	private Long id;
	private Long cid;
	private String orderNo;
	private String orderId;
	private String status;
	private String errorMessage;
	private String phone;
	private String money;
	private String pcode;
	private String type;
	private Date creationDate;
	
	public Order() {}

	public Order(String status, String message) {
		this.setStatus(status);
		this.setErrorMessage(message);
	}
	
	public Order create(Long cid, String orderNo, String orderId, String phone, String money, String pcode, String type) {
		this.setCid(cid);
		this.setOrderNo(orderNo);
		this.setOrderId(orderId);
		this.setCreationDate(new Date());
		this.setPhone(phone);
		this.setMoney(money);
		this.setPcode(pcode);
		this.setType(type);
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
