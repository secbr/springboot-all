package com.choupangxia.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/2 11:25 AM
 **/
public class StringSerializer extends JsonSerializer<String> {

	@Override
	public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if("VIP".equals(value)){
			gen.writeString("商户");
		} else {
			gen.writeString("用户");
		}

	}

}
