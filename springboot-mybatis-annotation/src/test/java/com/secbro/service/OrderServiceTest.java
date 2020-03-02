package com.secbro.service;

import com.secbro.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceTest {

	@Resource
	private OrderService orderService;

	@org.junit.jupiter.api.Order(1)
	@Test
	void save() {
		for (int i = 1; i <= 3; i++) {
			Order order = new Order();
			order.setOrderNo("N00" + i);
			order.setAmount(10000);
			orderService.save(order);
		}
	}

	@org.junit.jupiter.api.Order(2)
	@Test
	void update() {
		Order order = new Order();
		order.setId(1);
		order.setOrderNo("N001");
		order.setAmount(8888);
		orderService.update(order);
	}

	@org.junit.jupiter.api.Order(3)
	@Test
	void delete() {
		orderService.delete(2);
	}

	@org.junit.jupiter.api.Order(4)
	@Test
	void findById() {
		Order order = orderService.findById(3);
		log.info("订单信息：{}", order);
	}

	@org.junit.jupiter.api.Order(5)
	@Test
	void findAll() {
		List<Order> list = orderService.findAll();
		log.info("所有订单信息：{}", list);
	}
}