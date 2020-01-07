package com.secbro2.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/7 4:46 PM
 **/
//@Configuration
public class FastJsonConfiguration {

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
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

		return new HttpMessageConverters(converter);
	}
}
