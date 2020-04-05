package com.secbro.service;

import com.secbro.entity.SystemConfig;
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

	@Cacheable(value = "systemConfig")
	public SystemConfig getConfig() {
		log.info("获取配置信息...");
		SystemConfig config = new SystemConfig();
		config.setKey("activate");
		config.setValue("0");
		return config;
	}

	@Cacheable(value = "systemConfig-2", key = "#p0")
	public SystemConfig getConfigByIdAndKey(int id, String key) {
		log.info("getConfigById获取配置信息...id={},key={}", id, key);
		return new SystemConfig();
	}

	@Cacheable(value = "systemConfig-1", condition = "#id >= 10")
	public SystemConfig getConfigById(int id) {
		log.info("getConfigById获取配置信息...id={}", id);
		return new SystemConfig();
	}


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
