package com.xuya.charge.phone.constant;

public enum OrderStatusEnum {

	SUCCESS(0), FAILED(1), PROCESSING(2), UNKNOWN(3);

	private Integer status;

	private OrderStatusEnum(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
}
