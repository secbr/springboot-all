package com.secbro;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
class RedisSetTest {

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@BeforeEach
	void init() {
		redisTemplate.setKeySerializer(RedisSerializer.string());
	}

	/**
	 * Redis操作Set类型数据，去重特性
	 */
	@Test
	void testSet() {
		SetOperations<String, String> operations = redisTemplate.opsForSet();
		operations.add("orderId", "1");
		operations.add("orderId", "2");
		operations.add("orderId", "3");
		operations.add("orderId", "3");

		Set<String> orderIds = operations.members("orderId");

		log.info("orderIds:{}", orderIds);
	}


	/**
	 * Redis操作ZSet类型数据
	 */
	@Test
	void testZSet() {
		ZSetOperations<String, String> operations = redisTemplate.opsForZSet();
		operations.add("orderId", "1", 3);
		operations.add("orderId", "2", 2);
		operations.add("orderId", "3", 1);
		operations.add("orderId", "4", 4);


		Set<String> orderIds = operations.range("orderId", 0, 3);
		for (String orderId : orderIds) {
			log.info("orderId:{}", orderId);
		}
	}

}