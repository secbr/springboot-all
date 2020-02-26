package com.secbro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/26 9:06 AM
 **/
@Configuration
@EnableWebSocket
public class WebSocketConfig {

	/**
	 * 注入ServerEndpointExporter；
	 * 该Bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

}
