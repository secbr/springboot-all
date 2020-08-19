package com.secbro2.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author sec
 * @version 1.0
 * @date 2020/8/17
 **/
@Component
public class Consumer {

	@JmsListener(destination = "sms.queue")
	public void receiveMsg(String text) {
		System.out.println("接收到消息 : " + text);
	}

}
