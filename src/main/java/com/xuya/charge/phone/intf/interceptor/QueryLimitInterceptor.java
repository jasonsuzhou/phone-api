package com.xuya.charge.phone.intf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.infra.cache.guava.QueryLimitCache;
import com.xuya.charge.phone.intf.exception.RestfulRequestException;

public class QueryLimitInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String cid = request.getParameter("cid");
		String uri = request.getRequestURI();
		String key = cid + uri;
		if (StringUtils.isNotBlank(QueryLimitCache.get(key))) {
			throw new RestfulRequestException(ReturnCode.ACCESS_DENIED, "please try 30s later");
		} else {
			QueryLimitCache.put(key, "0");
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}
	}

	
}
