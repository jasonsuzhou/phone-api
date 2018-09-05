package com.xuya.charge.phone.domain.model.order;

import java.util.Date;

public class Order {

	private Long id;
	private String orderId;
	private String phone;
	private Integer cardnum;
	private Date creationDate;
	private OrderCustomer orderCustomer;

	public Order(OrderCustomer orderCustomer) {
		this.orderCustomer = orderCustomer;
	}
	
	public Order create(String phone, Integer cardnum) {
		this.setOrderId("");// TODO
		this.setCreationDate(new Date());
		this.setPhone(phone);
		this.setCardnum(cardnum);
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCardnum() {
		return cardnum;
	}

	public void setCardnum(Integer cardnum) {
		this.cardnum = cardnum;
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
