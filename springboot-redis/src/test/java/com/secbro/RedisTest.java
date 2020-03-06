package com.secbro;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
class RedisTest {


	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	@Test
	void testSimple() {
		redisTemplate.opsForValue().set("myWeb", "www.choupangxia.com");
		Assertions.assertEquals("www.choupangxia.com", redisTemplate.opsForValue().get("myWeb"));
	}

	@Test
	void testStringTemplate() {
		ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
		operations.set("wechat", "541075754");
		Assertions.assertEquals("541075754", operations.get("wechat"));
	}

	@Test
	void testKeySerializer() {
		redisTemplate.setKeySerializer(RedisSerializer.string());
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		operations.set("myWeb1", "www.choupangxia.com");
		Assertions.assertEquals("www.choupangxia.com", operations.get("myWeb1"));
	}

	@Test
	void testKeySerializer1() {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		ValueOperations<String, Object> operations = redisTemplate.opsForValue();
		operations.set("myWeb2", "www.choupangxia.com");
		Assertions.assertEquals("www.choupangxia.com", operations.get("myWeb2"));
	}
}