package com.xuya.charge.phone.domain.model.provider.event;

import com.xuya.charge.phone.domain.event.GuavaDomainEventPublisher;

public class ProviderEventPublisher extends GuavaDomainEventPublisher {

	@Override
	public String identify() {
		return "provider_event_publisher";
	}

	public static ProviderEventPublisher getInstance() {
		return ProviderEventPublisherHolder.instance;
	}

	private static class ProviderEventPublisherHolder {
		private static ProviderEventPublisher instance = new ProviderEventPublisher();
	}

}
