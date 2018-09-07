package com.xuya.charge.phone.intf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xuya.charge.phone.application.exception.ApplicationException;
import com.xuya.charge.phone.application.service.OrderApplicationService;
import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.intf.dto.OrderResultDTO;
import com.xuya.charge.phone.intf.dto.QueryOrderResultCommand;
import com.xuya.charge.phone.intf.dto.Result;
import com.xuya.charge.phone.intf.exception.RestfulRequestException;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderApplicationService orderApplicationService;
	
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public Result queryOrderStatus(@Valid QueryOrderResultCommand command, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new Result.Builder().buildError(ReturnCode.PARAM_INCORRECT, bindingResult.getFieldError().getDefaultMessage());
		}
		OrderResultDTO dto = null;
		try {
			dto = orderApplicationService.queryOrderResult(command);
		} catch (ApplicationException e) {
			throw new RestfulRequestException(e.getCode(), e.getMessage());
		}
		return new Result.Builder().status(0).code(ReturnCode.SUCCESS)
				.addPayloadData("result", dto.getStatus())
				.addPayloadData("desc", dto.getMessage())
				.build();
	}


}
