package com.secbro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *
 * 注解@EnableWebSocketMessageBroker开启使用STOMP协议来传输基于代理的消息
 * @author sec
 * @version 1.0
 * @date 2020/2/26 9:06 AM
 **/
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	/**
	 * 注册STOMP协议的节点，并指定映射的URL
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// 注册STOMP协议节点
		registry.addEndpoint("/simple")
				// 解决跨域问题
				.setAllowedOrigins("*")
				// 指定端点使用SockJS协议
				.withSockJS();
	}

	/**
	 * 配置消息代理
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 由于是实现推送功能，这里的消息代理是/topic
		// 启动简单Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
		registry.enableSimpleBroker("/topic");
	}

}
