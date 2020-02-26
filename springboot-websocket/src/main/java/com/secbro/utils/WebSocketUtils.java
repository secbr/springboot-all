package com.secbro.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/26 9:10 AM
 **/
public final class WebSocketUtils {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketUtils.class);

	/**
	 * 存储WebSocket session；<br/>
	 * 以用户的姓名为key，WebSocket为对象为value；
	 */
	public static final Map<String, Session> CLIENTS = new ConcurrentHashMap<>();

	/**
	 * 使用连接发送数据
	 * @param session 用户session
	 * @param message 发送内容
	 */
	public static void sendMessage(Session session, String message) {
		if (session == null) {
			return;
		}
		final RemoteEndpoint.Basic basic = session.getBasicRemote();
		if (basic == null) {
			return;
		}
		try {
			basic.sendText(message);
		} catch (IOException e) {
			logger.error("sendMessage IOException ", e);
		}
	}

	public static void sendMessageAll(String message) {
		CLIENTS.forEach((sessionId, session) -> sendMessage(session, message));
	}

	/**
	 * 获取所有在线用户
	 */
	public static String getOnlineInfo(){
		Set<String> userNames = CLIENTS.keySet();
		if(userNames.size() ==0){
			return "当前无人在线...";
		}
		return  CLIENTS.keySet().toString() + "在线";
	}

}
