package com.secbro2.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author sec
 * @version 1.0
 * @date 2020/8/17
 **/
@Configuration
public class MyMqConfig {


	@Bean("queueListenerFactory")
	public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setPubSubDomain(false);
		return factory;
	}

	@Bean("topicListenerFactory")
	public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setPubSubDomain(true);
		return factory;
	}

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sms.queue");
	}

	@Bean
	public Topic topic() {
		return new ActiveMQTopic("sms.topic");
	}


}
