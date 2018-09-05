package com.xuya.charge.phone.domain.model.order;

public class OrderCustomer {

	private Long customerId;
	private Long orderKey;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(Long orderKey) {
		this.orderKey = orderKey;
	}

}
