package com.secbro.redis.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author sec
 * @version 1.0
 * @date 2021/10/17
 **/
@Configuration
public class RedisConfig {

	//lock script
	private static final String LOCK_SCRIPT = " if redis.call('setnx',KEYS[1],ARGV[1]) == 1 " +
			" then redis.call('expire',KEYS[1],ARGV[2]) " +
			" return 1 " +
			" else return 0 end ";
	private static final String UNLOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call" +
			"('del', KEYS[1]) else return 0 end";

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
				new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();

		return redisTemplate;
	}
	
	@Bean
	public DefaultRedisScript<Boolean> lockRedisScript() {
		DefaultRedisScript<Boolean> defaultRedisScript = new DefaultRedisScript<>();
		defaultRedisScript.setResultType(Boolean.class);
		defaultRedisScript.setScriptText(LOCK_SCRIPT);
		return defaultRedisScript;
	}

	@Bean
	public DefaultRedisScript<Long> unlockRedisScript() {
		DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
		defaultRedisScript.setResultType(Long.class);
		defaultRedisScript.setScriptText(UNLOCK_SCRIPT);
		return defaultRedisScript;
	}

}
