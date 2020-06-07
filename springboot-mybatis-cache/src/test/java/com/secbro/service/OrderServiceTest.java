package com.secbro.service;

import com.secbro.mapper.OrderMapper;
import com.secbro.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
	private OrderMapper orderMapper;

	@Resource
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * Mybatis的org.apache.ibatis.session.Configuration类中默认配置
	 */
	@Test
	public void showDefaultCacheConfiguration() {
		System.out.println("一级缓存范围: " + sqlSessionFactory.getConfiguration().getLocalCacheScope());
		System.out.println("二级缓存是否被启用: " + sqlSessionFactory.getConfiguration().isCacheEnabled());
	}

	@Test
	void userFirstCache() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		for (int i = 0; i < 3; i++) {
			Order order = orderMapper.findById(1);
			log.info("订单信息：{}", order);
		}
	}

//	@Transactional
	@Test
	void userFirstCache1() {
		for (int i = 0; i < 3; i++) {
			Order order = orderMapper.findById(1);
			log.info("订单信息：{}", order);
		}
	}

	@Test
	void userSecondCache() {
		for (int i = 0; i < 3; i++) {
			Order order = orderService.findById(1);
			log.info("订单信息：{}", order);
		}
	}
}