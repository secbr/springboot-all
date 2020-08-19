package com.secbro2.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sec
 * @version 1.0
 * @date 2020/8/17
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqTests {

	@Autowired
	private Producer producer;

	@Test
	public void sendSimpleQueueMessage() {
		this.producer.sendMsg("提现200.00元");
	}

	@Test
	public void sendSimpleTopicMessage() {
		this.producer.sendTopic("提现200.00元");
	}
}