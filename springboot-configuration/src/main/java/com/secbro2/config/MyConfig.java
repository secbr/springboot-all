package com.secbro2.config;

import com.secbro2.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/25 5:55 PM
 **/
@Configuration
public class MyConfig {

	@Bean
	@ConfigurationProperties(prefix = "user")
	public User user() {
		return new User();
	}
}
