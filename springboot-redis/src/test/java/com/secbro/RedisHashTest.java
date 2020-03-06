package com.secbro;

import com.secbro.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
class RedisHashTest {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@BeforeEach
	void init() {
		redisTemplate.setKeySerializer(RedisSerializer.string());
	}

	/**
	 * 新增Hash值
	 */
	@Test
	void testObject() {

		Order order = new Order();
		order.setId(1);
		order.setAmount(6666);
		order.setOrderNo("N111");

		HashOperations<String, String, Order> operations = redisTemplate.opsForHash();
		operations.put("orders", "userId-1", order);

		order.setOrderNo("N112");
		operations.put("orders", "userId-2", order);

		Order cached = operations.get("orders", "userId-1");

		Assertions.assertEquals("N111", cached.getOrderNo());
	}

	/**
	 * 删除对象操作
	 */
	@Test
	void testDeleteObject() {
		redisTemplate.opsForHash().delete("orders", "userId-1");
	}


}