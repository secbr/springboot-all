package com.secbro.dao;

import com.secbro.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

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
	void getOne() {
		Optional<Order> orderOptional = orderDao.findById(1);
		orderOptional.ifPresent(order -> log.info("订单信息:{}", order));

		List<Order> list = orderDao.findAll();
		log.info("所有:{}", list);
	}

	@Test
	void totalTest() {

		// 增加
		for (int i = 0; i < 4; i++) {
			Order order = new Order();
			order.setAmount(6666);
			order.setOrderNo("N6666");
			orderDao.save(order);
		}

		// 删除 id为1的记录
		orderDao.deleteById(1);

		// 修改 id为2的记录
		Optional<Order> optionalOrder = orderDao.findById(2);
		optionalOrder.ifPresent(order -> {
			order.setAmount(8888);
			orderDao.save(order);
		});

		// 倒序查询
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		List<Order> orders = orderDao.findAll(sort);
		log.info("倒序查询结果：{}", orders);

		// 根据Example查询
		Order paramOrder = new Order();
		paramOrder.setAmount(6666);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id");
		Example<Order> example = Example.of(paramOrder,matcher);
		orders = orderDao.findAll(example);
		log.info("根据Example查询：{}", orders);

		// 分页查询
		Page<Order> orderPage = orderDao.findAll(PageRequest.of(0,10,sort));
		log.info("分页查询：{}", orderPage.getContent());

	}

	@Test
	void testCustomMethod(){
		int count = orderDao.countByAmount(6666);
		log.info("count:{}",count);
		List<Order> list = orderDao.findByOrderNo("N6666");
		log.info("list:{}",list);

		list = orderDao.findByAmount(6666);
		log.info("list:{}",list);
	}

}