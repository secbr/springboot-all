package com.secbro;

import com.secbro.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
class RedisObjectTest {


	@Resource
	private RedisTemplate<String, Order> redisTemplate;

	@BeforeEach
	void init() {
		redisTemplate.setKeySerializer(RedisSerializer.string());
	}

	/**
	 * 对象操作
	 */
	@Test
	void testObject() {
		Order order = new Order();
		order.setId(1);
		order.setAmount(6666);
		order.setOrderNo("N110");
		ValueOperations<String, Order> operations = redisTemplate.opsForValue();

		operations.set("order-1", order);
		Order cachedOrder = operations.get("order-1");

		Assertions.assertEquals("N110", cachedOrder.getOrderNo());
	}

	/**
	 * 删除对象操作
	 */
	@Test
	void testDeleteObject() {
		redisTemplate.delete("order-1");

		boolean exists = redisTemplate.hasKey("order-1");

		Assertions.assertFalse(exists);
	}


}