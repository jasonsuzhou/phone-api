package com.xuya.charge.phone.application.service;

import java.math.BigDecimal;

import com.xuya.charge.phone.application.exception.ApplicationException;
import com.xuya.charge.phone.intf.dto.QueryBalanceCommand;

public interface CustomerApplicationService {
	
	BigDecimal currentBalance(QueryBalanceCommand command) throws ApplicationException;

}
