package com.xuya.charge.phone.domain.repository;

import com.xuya.charge.phone.domain.model.order.Order;

public interface IOrderRepository {
	
	public Order findOrder(String orderId);

}
