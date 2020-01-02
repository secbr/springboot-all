package com.choupangxia.serializer;

import com.choupangxia.entity.Order;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/2 11:03 AM
 **/
public class OrderSerializer extends JsonSerializer<Order> {


	@Override
	public void serialize(Order value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("order-no", value.getOrderNo());
		gen.writeNumberField("amount",value.getAmount());
		gen.writeStringField("date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		gen.writeEndObject();

	}
}
