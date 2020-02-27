package com.secbro.controller;

import com.secbro.entity.RequestMessage;
import com.secbro.entity.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/26 8:38 PM
 **/
@Slf4j
@RestController
public class StompController {

	private static AtomicInteger index = new AtomicInteger();

	@Resource
	private SimpMessagingTemplate messagingTemplate;

	/**
	 * 注解@MessageMapping与@RequestMapping类似，定位请求地址；
	 * 注解@SendTo，指定当服务器有消息需要推送的时候，订阅了@SendTo中路径的客户端发送消息。
	 */
	@MessageMapping("/hello")
	@SendTo("/topic/hello")
	public ResponseMessage hello(RequestMessage message) {
		ResponseMessage resp = new ResponseMessage();
		String hello = "welcome," + message.getName() + " !";
		log.info("ResponseMessage:{}", hello);
		resp.setMessage(hello);
		return resp;
	}

	/**
	 * 定时推送消息，每隔两秒钟返回一次消息给订阅"/topic/callback"的客户端
	 */
	@Scheduled(fixedRate = 5000)
	public void callback() {
		// 发送消息
		messagingTemplate.convertAndSend("/topic/callback", "index: " + index.getAndIncrement());
	}
}
