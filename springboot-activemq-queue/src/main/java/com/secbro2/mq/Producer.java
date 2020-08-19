package com.secbro2.mq;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * @author sec
 * @version 1.0
 * @date 2020/8/17
 **/
@Component
public class Producer {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Resource
	private Queue queue;

	public void sendMsg(String msg) {
		System.out.println("发送消息内容 :" + msg);
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

}
