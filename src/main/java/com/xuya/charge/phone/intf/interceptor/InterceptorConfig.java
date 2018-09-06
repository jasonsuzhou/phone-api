package com.xuya.charge.phone.intf.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Bean
	public WhiteIPChecker getWhiteIPChecker() {
		return new WhiteIPChecker();
	}
	
	@Bean
	public QueryLimitInterceptor getQueryLimitInterceptor() {
		return new QueryLimitInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getWhiteIPChecker()).addPathPatterns("/**");
		registry.addInterceptor(getQueryLimitInterceptor()).addPathPatterns("/api/customer/balance","/api/order/result");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
