package com.xuya.charge.phone.domain.event;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

public abstract class GuavaDomainEventPublisher implements DomainEventPublisher<DomainEvent> {
	
	private EventBus syncBus = new EventBus(identify());
	private EventBus asyncBus = new AsyncEventBus(identify(), Executors.newFixedThreadPool(10));

	@Override
	public void register(Object listener) {
		syncBus.register(listener);
		asyncBus.register(listener);
	}

	@Override
	public void publish(DomainEvent event) {
		syncBus.post(event);
	}

	@Override
	public void asyncPublish(DomainEvent event) {
		asyncBus.post(event);
	}

}
