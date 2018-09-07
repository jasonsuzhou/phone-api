package com.xuya.charge.phone.application.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xuya.charge.phone.application.service.ProviderApplicationService;
import com.xuya.charge.phone.domain.model.provider.event.ProviderCallbackReceivedEvent;
import com.xuya.charge.phone.domain.model.provider.event.ProviderEventPublisher;
import com.xuya.charge.phone.intf.dto.ProviderCallbackCommand;

@Service
public class ProviderApplicationServiceImpl implements ProviderApplicationService {
	
	@Override
	public void updateOrderResult(ProviderCallbackCommand command) {
		String message = JSON.toJSONString(command);
		ProviderEventPublisher.getInstance().asyncPublish(new ProviderCallbackReceivedEvent(message));
	}

}
