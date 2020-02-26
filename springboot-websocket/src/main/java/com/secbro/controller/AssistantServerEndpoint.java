package com.secbro.controller;

import com.secbro.utils.WebSocketUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import static com.secbro.utils.WebSocketUtils.CLIENTS;
import static com.secbro.utils.WebSocketUtils.sendMessageAll;

/**
 * 说明：
 * 1、@ServerEndpoint注解中指定WebSocket协议的地址；
 * 2、@OnOpen、@OnMessage、@OnClose、@OnError注解与WebSocket中监听事件对应
 * @author sec
 * @version 1.0
 * @date 2020/2/19 10:17 AM
 **/
@Slf4j
@RestController
@ServerEndpoint("/helper/{username}")
public class AssistantServerEndpoint {

	/**
	 * 连接建立时触发
	 */
	@OnOpen
	public void openSession(@PathParam("username") String username, Session session) {
		log.info("用户{}登录", username);
		String message = "欢迎用户[" + username + "] 已进入！";
		// 发送登录消息给其他人
		sendMessageAll(message);

		// 获取当前在线人数，发给自己
		String onlineInfo = WebSocketUtils.getOnlineInfo();
		WebSocketUtils.sendMessage(session, onlineInfo);

		// 添加自己到map中
		CLIENTS.put(username, session);
	}

	/**
	 * 客户端接收服务端数据时触发
	 */
	@OnMessage
	public void onMessage(@PathParam("username") String username, String message) {
		log.info("发送消息：{}", message);
		sendMessageAll("[" + username + "] : " + message);
	}

	/**
	 * 连接关闭时触发
	 */
	@OnClose
	public void onClose(@PathParam("username") String username, Session session) {
		//当前的Session移除
		CLIENTS.remove(username);
		// 离开消息通知所有人
		sendMessageAll("[" + username + "] 已离开！");
		try {
			session.close();
		} catch (IOException e) {
			log.error("onClose error", e);
		}
	}

	/**
	 * 通信发生错误时触发
	 */
	@OnError
	public void onError(Session session, Throwable throwable) {
		try {
			session.close();
		} catch (IOException e) {
			log.error("onError Exception", e);
		}
		log.info("Throwable msg " + throwable.getMessage());
	}

}
