package com.xuya.charge.phone.intf.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xuya.charge.phone.application.exception.ApplicationException;
import com.xuya.charge.phone.application.service.CustomerApplicationService;
import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.intf.dto.QueryBalanceCommand;
import com.xuya.charge.phone.intf.dto.Result;
import com.xuya.charge.phone.intf.exception.RestfulRequestException;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerApplicationService customerApplicationService;
	
	@RequestMapping(value="/balance", method=RequestMethod.GET)
	public Result queryBalance(@Valid QueryBalanceCommand command, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new Result.Builder().buildError(ReturnCode.PARAM_INCORRECT, bindingResult.getFieldError().getDefaultMessage());
		}
		BigDecimal balance = null;
		try {
			balance = customerApplicationService.currentBalance(command);
		} catch (ApplicationException e) {
			throw new RestfulRequestException(e.getCode(), e.getMessage());
		}
		return new Result.Builder().status(0).code(ReturnCode.SUCCESS).addPayloadData("balance", balance).build();
	}

}
