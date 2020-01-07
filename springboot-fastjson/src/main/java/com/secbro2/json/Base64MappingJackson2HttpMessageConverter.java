package com.secbro2.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/7 1:52 PM
 **/
@Slf4j
public class Base64MappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

	@Override
	protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException,
			HttpMessageNotWritableException {

		// 使用Jackson的ObjectMapper将Java对象转换成Json String
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(object);
		log.info(json);
		// Base64处理
		String base64Result = Base64.encode(json.getBytes());
		log.info(base64Result);
		// 输出
		outputMessage.getBody().write(base64Result.getBytes());
	}

}
