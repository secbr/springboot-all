package com.secbro2.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/7 5:13 PM
 **/
@Slf4j
@Configuration
//@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO 同样可在此处添加converter
		// 定义一个convert转换消息的对象
		/*FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

		// 添加fastJson的配置信息
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		// 处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON);

		// 在convert中添加配置信息
		converter.setSupportedMediaTypes(fastMediaTypes);
		converter.setFastJsonConfig(fastJsonConfig);
		converters.add(converter);*/

	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
		// TODO 同样可在此处添加converter
		// 定义一个convert转换消息的对象
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

		// 添加fastJson的配置信息
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		// 处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON);

		// 在convert中添加配置信息
		converter.setSupportedMediaTypes(fastMediaTypes);
		converter.setFastJsonConfig(fastJsonConfig);
		converters.add(converter);

		print(converters);
	}

	private void print(List<HttpMessageConverter<?>> converters){
		converters.forEach((converter) -> log.info("converter:{}", converter));
	}

}
