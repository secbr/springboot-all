package com.secbro2.config;

import com.secbro2.interceptor.RequestIdTraceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2020/10/19
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Resource
	private RequestIdTraceInterceptor requestIdTraceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 添加拦截器
		registry.addInterceptor(requestIdTraceInterceptor);
	}
}
