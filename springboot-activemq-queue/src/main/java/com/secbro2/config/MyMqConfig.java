package com.secbro2.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author sec
 * @version 1.0
 * @date 2020/8/17
 **/
@Configuration
public class MyMqConfig {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sms.queue");
	}

}
