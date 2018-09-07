package com.xuya.charge.phone.domain.event;

public interface DomainEventPublisher<T extends DomainEvent> {

	String identify();

	void register(Object listener);

	void publish(T event);

	void asyncPublish(T event);

}
