package com.secbro2.controller;

import com.secbro2.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/7 4:53 PM
 **/
@RestController
public class OrderController {

	@GetMapping
	public Order getOrderInfo() {
		Order order = new Order();
		order.setOrderNo("NO10000");
		order.setAmount(new BigDecimal("100"));
		return order;
	}
}
