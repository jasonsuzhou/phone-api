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
	
	@Bean
	public MaintainStatusChecker getMaintainStatusChecker() {
		return new MaintainStatusChecker();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getMaintainStatusChecker()).addPathPatterns("/api/**");
		registry.addInterceptor(getWhiteIPChecker()).excludePathPatterns("/api/provider/order/back/**").addPathPatterns("/api/**");
		registry.addInterceptor(getQueryLimitInterceptor()).addPathPatterns("/api/customer/balance","/api/order/result");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
