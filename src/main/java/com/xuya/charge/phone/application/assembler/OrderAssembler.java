package com.xuya.charge.phone.application.assembler;

import org.springframework.stereotype.Component;

import com.xuya.charge.phone.constant.OrderStatusEnum;
import com.xuya.charge.phone.domain.model.order.Order;
import com.xuya.charge.phone.intf.dto.OrderResultDTO;

@Component
public class OrderAssembler {
	
	public OrderResultDTO assembleOrderResultDTO(Order order) {
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

}
