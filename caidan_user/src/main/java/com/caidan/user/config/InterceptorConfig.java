package com.caidan.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.caidan.user.interceptor.JwtInterceptor;

@Component
public class InterceptorConfig extends WebMvcConfigurationSupport{

	@Autowired
	JwtInterceptor jwtInterceptor;
	protected void addInterceptors(InterceptorRegistry registry) {
		registry
			.addInterceptor(jwtInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/**/login/**");
	}
}
