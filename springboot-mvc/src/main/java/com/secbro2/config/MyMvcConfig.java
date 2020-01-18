package com.secbro2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/17 10:03 AM
 **/
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 对于一些简单的请求，比如不需要从后台获取数据的请求，可以采用这种方式直接返回页面，而不需要在Controller中写一些空方法
		registry.addViewController("/hello").setViewName("hello");
	}

}
