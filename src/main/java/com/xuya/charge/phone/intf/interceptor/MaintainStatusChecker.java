package com.xuya.charge.phone.intf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import com.xuya.charge.phone.constant.ReturnCode;
import com.xuya.charge.phone.infra.cache.CacheKeys;
import com.xuya.charge.phone.infra.cache.guava.ConfigCache;
import com.xuya.charge.phone.intf.exception.RestfulRequestException;

public class MaintainStatusChecker implements HandlerInterceptor {
	
	@Autowired
	private StringRedisTemplate configStringRedisTemplate;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String result = configStringRedisTemplate.opsForValue().get(CacheKeys.MAINTAIN_KEY);
		if (ConfigCache.MAINTAIN_VALUE_TRUE.equals(result)) {
			throw new RestfulRequestException(ReturnCode.SYSTEM_MAINTAIN, "system is under maintainance status");
		} else {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}
	}

}
