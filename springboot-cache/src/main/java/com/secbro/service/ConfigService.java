package com.secbro.service;

import com.secbro.entity.SystemConfig;
import lombok.extern.slf4j.Slf4j;
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

	@Cacheable(value = "systemConfig")
	public SystemConfig getConfig() {
		log.info("获取配置信息...");
		SystemConfig config = new SystemConfig();
		config.setKey("activate");
		config.setValue("0");
		return config;
	}

}
