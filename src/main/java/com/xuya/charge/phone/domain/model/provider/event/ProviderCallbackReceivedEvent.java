package com.xuya.charge.phone.domain.model.provider.event;

import com.xuya.charge.phone.domain.event.DomainEvent;

public class ProviderCallbackReceivedEvent extends DomainEvent {
	
	private String message;
	
	public ProviderCallbackReceivedEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String identify() {
		return "provider_callback_received_event";
	}

}
