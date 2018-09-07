package com.xuya.charge.phone.domain.event;

import java.util.Date;

public abstract class DomainEvent {

	private Date occurredTime;

	public abstract String identify();

	public Date getOccurredTime() {
		return occurredTime;
	}

	public void setOccurredTime(Date occurredTime) {
		this.occurredTime = occurredTime;
	}

}
