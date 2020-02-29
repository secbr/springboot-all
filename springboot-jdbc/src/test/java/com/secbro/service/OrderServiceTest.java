package com.secbro.service;

import com.secbro.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
class OrderServiceTest {

	@Resource
	private OrderService orderService;

	@Test
	void save() {
		Order order = new Order();
		order.setOrderNo("N003");
		order.setAmount(10000);
		orderService.save(order);
	}

	@Test
	void update() {
		Order order = new Order();
		order.setId(1);
		order.setOrderNo("N001");
		order.setAmount(8888);
		orderService.update(order);
	}

	@Test
	void delete() {
		orderService.delete(2);
	}

	@Test
	void findById() {
		Order order = orderService.findById(3);
		log.info("订单信息：{}", order);
	}

	@Test
	void findAll() {
		List<Order> list = orderService.findAll();
		log.info("所有订单信息：{}", list);
	}
}