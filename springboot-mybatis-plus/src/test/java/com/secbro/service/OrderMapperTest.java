package com.secbro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.secbro.mapper.OrderMapper;
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
class OrderMapperTest {

	@Resource
	private OrderMapper orderMapper;

	@Test
	void queryByPage() {
		//参数一是当前页，参数二是每页个数
		IPage<Order> orderPage = new Page<>(1, 2);
		orderPage = orderMapper.selectPage(orderPage, null);
		List<Order> list = orderPage.getRecords();
		for (Order order : list) {
			System.out.println(order);
		}
	}


}