package com.secbro.dao;

import com.secbro.dao.db1.OrderDb1Dao;
import com.secbro.dao.db2.OrderDb2Dao;
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
class OrderDb1DaoTest {

	@Resource
	private OrderDb1Dao orderDb1Dao;

	@Resource
	private OrderDb2Dao orderDb2Dao;

	@Test
	void totalTest() {
		// 增加
		Order order = new Order();
		order.setAmount(6666);
		order.setOrderNo("N6666");
		orderDb1Dao.save(order);
		orderDb2Dao.save(order);
	}


}