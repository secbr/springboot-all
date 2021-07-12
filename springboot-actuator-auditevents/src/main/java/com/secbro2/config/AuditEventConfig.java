package com.secbro2.config;

import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sec
 * @version 1.0
 * @date 2021/7/12
 **/
@Configuration
public class AuditEventConfig {

	@Bean
	public InMemoryAuditEventRepository repository(){
		return new InMemoryAuditEventRepository();
	}
}
