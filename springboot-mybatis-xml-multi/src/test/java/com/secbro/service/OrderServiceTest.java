package com.secbro.service;

import com.secbro.model.Order;
import com.secbro.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
class OrderServiceTest {

	@Resource
	private OrderService orderService;

	@Resource
	private UserService userService;

	@Test
	void findById() {
		Order order = orderService.findById(1);
		log.info("订单信息：{}", order);

		User user = userService.findById(1);
		log.info("用户信息：{}", user);
	}
}