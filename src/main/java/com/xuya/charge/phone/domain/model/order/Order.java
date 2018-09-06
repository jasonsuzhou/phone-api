package com.xuya.charge.phone.domain.model.order;

import java.util.Date;

public class Order {

	private Long id;
	private String orderId;
	private String status;
	private String errorMessage;
	private String phone;
	private Integer money;
	private Date creationDate;
	private OrderCustomer orderCustomer;

	public Order(OrderCustomer orderCustomer) {
		this.orderCustomer = orderCustomer;
	}
	
	public Order(String status, String message) {
		this.setStatus(status);
		this.setErrorMessage(message);
	}
	
	public Order create(String phone, Integer money) {
		this.setOrderId("");// TODO
		this.setCreationDate(new Date());
		this.setPhone(phone);
		this.setMoney(money);
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public OrderCustomer getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(OrderCustomer orderCustomer) {
		this.orderCustomer = orderCustomer;
	}

}
