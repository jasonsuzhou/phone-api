package com.xuya.charge.phone.domain.model.order.event;

import com.xuya.charge.phone.domain.event.DomainEvent;
import com.xuya.charge.phone.domain.model.order.Order;

public class OrderCreatedEvent extends DomainEvent {
	
	private Order order;
	
	public OrderCreatedEvent(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	@Override
	public String identify() {
		return "order_created_event";
	}

}
