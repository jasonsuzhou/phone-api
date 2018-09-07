package com.xuya.charge.phone.domain.model.order.event;

import com.xuya.charge.phone.domain.event.GuavaDomainEventPublisher;

public class OrderEventPublisher extends GuavaDomainEventPublisher {

	@Override
	public String identify() {
		return "order_event_publisher";
	}
	
	public static OrderEventPublisher getInstance() {
		return OrderEventPublisherHolder.instance;
	}
	
	private static class OrderEventPublisherHolder {
		private static OrderEventPublisher instance = new OrderEventPublisher();
	}

}
