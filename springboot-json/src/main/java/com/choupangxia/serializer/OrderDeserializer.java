package com.choupangxia.serializer;

import com.choupangxia.entity.Order;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/2 4:32 PM
 **/
public class OrderDeserializer extends JsonDeserializer<Order> {

	@Override
	public Order deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
		JsonNode node = parser.getCodec().readTree(parser);
		String userName = node.get("orderNo").asText();
		Order order = new Order();
		order.setOrderNo(userName);
		order.setAmount(node.get("amount").asDouble());
		return order;
	}
}
