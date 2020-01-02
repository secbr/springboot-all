package com.choupangxia.controller;

import com.choupangxia.entity.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/31 10:10 AM
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private ObjectMapper objectMapper;

	@GetMapping(value = "getOrderInfo", produces = "application/json;charset=UTF-8")
	public Order getOrderInfo() {
		Order order = new Order();
		order.setOrderNo("NO11111");
		order.setAmount(100.00);
		order.setType("VIP");
		return order;
	}

	@PostMapping("/addOrder")
	public void addOrder(String orderJson) throws JsonProcessingException {

		Order order = objectMapper.readValue(orderJson, Order.class);
		System.out.println("orderNo:" + order.getOrderNo());
		System.out.println("amount:" + order.getAmount());
	}


}
