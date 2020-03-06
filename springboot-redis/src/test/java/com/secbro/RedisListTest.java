package com.secbro;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
class RedisListTest {

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	@BeforeEach
	void init() {
		redisTemplate.setKeySerializer(RedisSerializer.string());
	}

	@Test
	void testObject() {
		ListOperations<String, String> operations = redisTemplate.opsForList();
		operations.leftPush("orderId", "1");
		operations.leftPush("orderId", "2");
		operations.leftPush("orderId", "3");

//		log.info("rightPop:{}", operations.rightPop("orderId"));
//		log.info("rightPop:{}", operations.rightPop("orderId"));
//		log.info("rightPop:{}", operations.rightPop("orderId"));

//		log.info("leftPop:{}", operations.leftPop("orderId"));
//		log.info("leftPop:{}", operations.leftPop("orderId"));
//		log.info("leftPop:{}", operations.leftPop("orderId"));

	}

}