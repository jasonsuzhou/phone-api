package com.xuya.charge.phone.application.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xuya.charge.phone.domain.model.order.Order;
import com.xuya.charge.phone.domain.model.order.event.OrderCreatedEvent;
import com.xuya.charge.phone.domain.model.order.event.OrderEventPublisher;
import com.xuya.charge.phone.infra.aliyunmq.AliyunMQMsgSender;

@Service
public class OrderCreatedListener {
	
	private Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

	@Autowired
	private AliyunMQMsgSender orderCreatedSender;
	
	public OrderCreatedListener() {
		OrderEventPublisher.getInstance().register(this);
	}
	
	public void listenOrderCreatedEvent(OrderCreatedEvent event) {
		Order order = event.getOrder();
		String message = JSON.toJSONString(order);
		try {
			orderCreatedSender.sendMessage(message);
		} catch (Exception e) {
			logger.error("Error::", e);
		}
	}

}
