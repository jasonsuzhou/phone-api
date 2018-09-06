package com.xuya.charge.phone.application.service;

import com.xuya.charge.phone.application.exception.ApplicationException;
import com.xuya.charge.phone.intf.dto.OrderResultDTO;
import com.xuya.charge.phone.intf.dto.QueryOrderResultCommand;

public interface OrderApplicationService {

	OrderResultDTO queryOrderResult(QueryOrderResultCommand command)  throws ApplicationException;
	
}
