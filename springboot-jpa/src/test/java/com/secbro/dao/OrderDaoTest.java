package com.secbro.dao;

import com.secbro.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
class OrderDaoTest {

	@Resource
	private OrderDao orderDao;

	@Test
	void getOne(){
		Optional<Order> orderOptional = orderDao.findById(1);
		orderOptional.ifPresent(order -> log.info("订单信息:{}", order));

		List<Order> list = orderDao.findAll();
		log.info("所有:{}",list);
	}

}