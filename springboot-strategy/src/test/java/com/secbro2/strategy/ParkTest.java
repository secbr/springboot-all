package com.secbro2.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author sec
 * @version 1.0
 * @date 2020/10/22
 **/
@Slf4j
public class ParkTest {

	@Test
	public void testStrategy() {
		DistanceContext distanceContext = new DistanceContext(new PeopleParkStrategy());
		int distance = distanceContext.calcDistance(2);
		log.info("获得距离：{}", distance);
	}

	@Test
	public void testFactoryStrategy() {
		FactoryContext factoryContext = new FactoryContext();
		factoryContext.factory(1);
		int distance = factoryContext.calcDistance(5);
		log.info("获得距离：{}", distance);
	}
}
