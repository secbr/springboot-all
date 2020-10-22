package com.secbro2.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("distanceSpringContext")
public class DistanceSpringContext {

	@Autowired
	private final Map<String, AbstractParkStrategy> strategyMap = new ConcurrentHashMap<>(3);

	private AbstractParkStrategy strategy;

	public void factory(String serviceName) {
		strategy = strategyMap.get(serviceName);
	}

	public int calcDistance(int count) {
		return strategy.calcDistance(count);
	}

}
