package com.xuya.charge.phone.intf.dto;

import com.xuya.charge.phone.constant.OrderStatusEnum;

public class OrderResultDTO {
	
	private OrderStatusEnum status;
	private String message;

	public Integer getStatus() {
		return status.getStatus();
	}

	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
