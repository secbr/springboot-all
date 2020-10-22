package com.secbro2.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2020/10/22
 **/
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ParkSpringV2Test {

	@Resource
	private DistanceSpringV2Context distanceSpringV2Context;

	@Test
	public void testSpringStrategy() {
		AbstractParkStrategy parkStrategy = distanceSpringV2Context.getService(1);
		int distance = parkStrategy.calcDistance(10);
		log.info("获得距离：{}", distance);
	}

}
