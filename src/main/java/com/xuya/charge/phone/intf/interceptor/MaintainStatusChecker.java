package com.xuya.charge.phone.intf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.infra.cache.guava.ConfigCache;
import com.xuya.charge.phone.intf.exception.RestfulRequestException;

public class MaintainStatusChecker implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (ConfigCache.MAINTAIN_VALUE_TRUE.equals(ConfigCache.get(ConfigCache.MAINTAIN_KEY))) {
			throw new RestfulRequestException(ReturnCode.SYSTEM_MAINTAIN, "system is under maintainance status");
		} else {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}
	}

}
