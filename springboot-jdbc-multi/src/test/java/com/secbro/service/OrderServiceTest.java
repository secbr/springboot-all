package com.secbro.service;

import com.secbro.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

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
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate primaryJdbcTemplate;

	@Resource
	@Qualifier("secondaryJdbcTemplate")
	private JdbcTemplate secondaryJdbcTemplate;

	@Test
	void save() {
		Order order = new Order();
		order.setOrderNo("N003");
		order.setAmount(10000);
		orderService.save(order, primaryJdbcTemplate);
		orderService.save(order, secondaryJdbcTemplate);
	}

}