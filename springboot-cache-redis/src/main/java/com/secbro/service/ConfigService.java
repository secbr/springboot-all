package com.secbro.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author sec
 * @version 1.0
 * @date 2020/4/1 11:42 上午
 **/
@Slf4j
@Service
public class ConfigService {

	public static int count = 0;

	@Cacheable(value = "getInt", key = "#id")
	public int getInt(int id) {
		log.info("getInt获取配置信息...id={}", id);
		return count;
	}

	/**
	 * 静态变量递增
	 */
	@CachePut(value = "getInt", key = "#id")
	public int addInt(int id) {
		return ++count;
	}

	@CacheEvict(value = "getInt", allEntries = true, beforeInvocation = true)
	public void clearInt() {
		// 操作数据库等删除存储数据
	}


}
