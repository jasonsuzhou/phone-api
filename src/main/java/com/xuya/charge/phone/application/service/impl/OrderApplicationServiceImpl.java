package com.xuya.charge.phone.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuya.charge.phone.application.exception.ApplicationException;
import com.xuya.charge.phone.application.service.OrderApplicationService;
import com.xuya.charge.phone.constant.OrderStatusEnum;
import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.domain.model.order.Order;
import com.xuya.charge.phone.domain.repository.IOrderRepository;
import com.xuya.charge.phone.domain.service.CustomerDomainService;
import com.xuya.charge.phone.infra.util.SummaryUtils;
import com.xuya.charge.phone.intf.dto.OrderResultDTO;
import com.xuya.charge.phone.intf.dto.QueryOrderResultCommand;

@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private CustomerDomainService customerDomainService;
	
	@Override
	public OrderResultDTO queryOrderResult(QueryOrderResultCommand command) throws ApplicationException {
		Long customerId = command.getCid();
		String secret = customerDomainService.getClientSecret(customerId);
		String orderId = command.getOrderId();
		String sign = command.getSign();
		checkQueryOrderResultRequest(customerId, orderId, secret, sign);
		Order order = orderRepository.findOrder(orderId);
		OrderResultDTO dto = new OrderResultDTO();
		if (order == null) {
			dto.setStatus(OrderStatusEnum.PROCESSING);
		} else {
			switch (order.getStatus()) {
			    case "处理完成":dto.setStatus(OrderStatusEnum.SUCCESS);break;
			    case "处理中":dto.setStatus(OrderStatusEnum.PROCESSING);break;
			    case "处理失败":
			    	dto.setStatus(OrderStatusEnum.FAILED);
			    	dto.setMessage(order.getErrorMessage());
			    	break;
				default:dto.setStatus(OrderStatusEnum.UNKNOWN);
			}
		}
		return dto;
	}
	
	private void checkQueryOrderResultRequest(Long customerId,String orderId, String secret, String sign) throws ApplicationException {
		String signString = customerId + orderId + secret;
		String newSign = SummaryUtils.getMD5Summary(signString);
		if (!newSign.equalsIgnoreCase(sign)) {
			throw new ApplicationException(ReturnCode.SIGN_INCORRECT,"sign not correct");
		}
	}
	
}
