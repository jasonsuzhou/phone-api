package com.xuya.charge.phone.application.service.impl;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.xuya.charge.phone.application.assembler.OrderAssembler;
import com.xuya.charge.phone.application.exception.ApplicationException;
import com.xuya.charge.phone.application.service.OrderApplicationService;
import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.domain.model.order.Order;
import com.xuya.charge.phone.domain.model.order.event.OrderCreatedEvent;
import com.xuya.charge.phone.domain.model.order.event.OrderEventPublisher;
import com.xuya.charge.phone.domain.repository.IOrderRepository;
import com.xuya.charge.phone.domain.service.CustomerDomainService;
import com.xuya.charge.phone.infra.util.IdWorker;
import com.xuya.charge.phone.infra.util.SummaryUtils;
import com.xuya.charge.phone.intf.dto.OrderResultDTO;
import com.xuya.charge.phone.intf.dto.QueryOrderResultCommand;
import com.xuya.charge.phone.intf.dto.SubmitOrderCommand;

@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private CustomerDomainService customerDomainService;
	
	@Autowired
	private OrderAssembler orderAssembler;
	
	@Autowired
	private Environment env;
	
	@Override
	public OrderResultDTO queryOrderResult(QueryOrderResultCommand command) throws ApplicationException {
		Long customerId = command.getCid();
		String secret = customerDomainService.getClientSecret(customerId);
		String orderId = command.getOrderid();
		String sign = command.getSign();
		checkQueryOrderResultRequest(customerId, orderId, secret, sign);
		Order order = orderRepository.findOrder(orderId);
		return orderAssembler.assembleOrderResultDTO(order);
	}

	@Override
	public String submitOrder(@Valid SubmitOrderCommand command) throws ApplicationException {
		Long customerId = command.getCid();
		String secret = customerDomainService.getClientSecret(customerId);
		String orderNo = command.getOrderno();
		String phone = command.getPhone();
		String money = command.getMoney();
		String pcode = command.getPcode();
		String type = command.getType();
		String sign = command.getSign();
		checkSubmitOrderRequest(customerId, orderNo, phone, money, secret, pcode,type, sign);
		String orderId = IdWorker.nextId(env.getProperty("machine.id"));
		Order order = new Order().create(customerId, orderNo, orderId, phone, money, pcode, type);
		OrderEventPublisher.getInstance().publish(new OrderCreatedEvent(order));
		return orderId;
	}
	
	private void checkQueryOrderResultRequest(Long customerId,String orderId, String secret, String sign) throws ApplicationException {
		String signString = customerId + orderId + secret;
		String newSign = SummaryUtils.getMD5Summary(signString);
		if (!newSign.equalsIgnoreCase(sign)) {
			throw new ApplicationException(ReturnCode.SIGN_INCORRECT,"sign not correct");
		}
	}
	
	private void checkSubmitOrderRequest(Long customerId,String orderNo,String phone, String money, String secret, String pcode,String type, String sign) throws ApplicationException {
		/* phone black check moved to phone-service module
		if ("0".equals(PhoneBlackCache.get(phone))) {
			throw new ApplicationException(ReturnCode.PHONE_BLACK,"phone is in black list");
		}
		*/
		String signString = null;
		if (StringUtils.isBlank(pcode) || "null".equals(pcode)) {
			signString = customerId + orderNo + phone + money + type + secret;
		} else {
			signString = customerId + orderNo + phone + money + pcode + type + secret;
		}
		
		String newSign = SummaryUtils.getMD5Summary(signString);
		if (!newSign.equalsIgnoreCase(sign)) {
			throw new ApplicationException(ReturnCode.SIGN_INCORRECT,"sign not correct");
		}
	}
}
