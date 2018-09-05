package com.xuya.charge.phone.intf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.infra.check.auth.ClientAndIPValidator;
import com.xuya.charge.phone.infra.util.WebUtils;
import com.xuya.charge.phone.intf.exception.RestfulRequestException;

public class WhiteIPChecker implements HandlerInterceptor {
	
	@Autowired
	private ClientAndIPValidator clientAndIPValidator;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cid = request.getParameter("cid");
		String ip = WebUtils.getClientIpAddr(request);
		String result = clientAndIPValidator.isValid(cid, ip);
		if (StringUtils.isNotBlank(result)) {
			throw new RestfulRequestException(ReturnCode.ACCESS_DENIED, result);
		} else {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}
	}

}
