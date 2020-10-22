package com.secbro2.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("distanceSpringV2Context")
public class DistanceSpringV2Context {

	@Autowired
	private final Map<String, AbstractParkStrategy> strategyMap = new ConcurrentHashMap<>(3);

	public AbstractParkStrategy getService(int parkId) {
		ParkEnum parkEnum = ParkEnum.valueOf(parkId);
		return strategyMap.get(parkEnum.getServiceName());
	}

}
