package com.xuya.charge.phone.intf.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.xuya.charge.phone.intf.dto.Result;

@RestControllerAdvice(basePackages = { "com.xuya.charge.phone.intf.controller", "com.xuya.charge.phone.intf.interceptor"})
public class GlobalExceptionHandler {

	@ExceptionHandler(value = RestfulRequestException.class)
	public Result jsonErrorHandler(HttpServletRequest req, RestfulRequestException e) {
		return new Result.Builder().buildError(e.getCode(), e.getMessage());
	}
}
