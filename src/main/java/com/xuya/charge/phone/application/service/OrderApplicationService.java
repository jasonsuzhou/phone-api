package com.xuya.charge.phone.application.service;

import javax.validation.Valid;

import com.xuya.charge.phone.application.exception.ApplicationException;
import com.xuya.charge.phone.intf.dto.OrderResultDTO;
import com.xuya.charge.phone.intf.dto.QueryOrderResultCommand;
import com.xuya.charge.phone.intf.dto.SubmitOrderCommand;

public interface OrderApplicationService {

	OrderResultDTO queryOrderResult(QueryOrderResultCommand command) throws ApplicationException;

	String submitOrder(@Valid SubmitOrderCommand command) throws ApplicationException;
	
}
