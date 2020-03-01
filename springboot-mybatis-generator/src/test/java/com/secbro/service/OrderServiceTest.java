package com.secbro.service;

import com.secbro.model.Order;
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

	@Test
	void findByOrderNo(){
		Order order = orderService.findByOrderNo("N001");
		log.info("返回结果:{}",order);
	}
}