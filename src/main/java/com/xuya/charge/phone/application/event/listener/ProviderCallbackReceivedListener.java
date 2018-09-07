package com.xuya.charge.phone.application.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.eventbus.Subscribe;
import com.xuya.charge.phone.domain.model.provider.event.ProviderCallbackReceivedEvent;
import com.xuya.charge.phone.domain.model.provider.event.ProviderEventPublisher;
import com.xuya.charge.phone.infra.aliyunmq.AliyunMQMsgSender;

@Service
public class ProviderCallbackReceivedListener {

	private Logger logger = LoggerFactory.getLogger(ProviderCallbackReceivedListener.class);

	@Autowired
	private AliyunMQMsgSender providerCallbackSender;

	public ProviderCallbackReceivedListener() {
		ProviderEventPublisher.getInstance().register(this);
	}

	@Subscribe
	public void listenProviderCallbackReceivedEvent(ProviderCallbackReceivedEvent event) {
		try {
			providerCallbackSender.sendMessage(event.getMessage());
		} catch (Exception e) {
			logger.error("Error::", e);
		}
	}

}
