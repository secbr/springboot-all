package com.secbro2.config;

import com.secbro2.json.Base64MappingJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/7 2:06 PM
 **/
@Configuration
public class JsonWebMvcConfigurer implements WebMvcConfigurer {

	/**
	 * 自定义base64处理的HttpMessageConverter
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.clear();
		converters.add(new Base64MappingJackson2HttpMessageConverter());
	}
}
