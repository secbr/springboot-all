package com.secbro2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * Web相关配置
 *
 * @author sec
 * @version 1.0
 * @date 2020/7/7 5:04 下午
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * 默认拦截器 其中lang表示切换语言的参数名
	 *
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		registry.addInterceptor(localeInterceptor);
	}
}
