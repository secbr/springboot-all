package com.secbro2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/17 10:15 AM
 **/
@Configuration
public class ViewResolverConfig {

	/*@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		// 设置ViewResolver对应的属性值
		resolver.setCharacterEncoding("UTF-8");
		resolver.setCache(false);
		// ...

		return resolver;
	}*/
}
