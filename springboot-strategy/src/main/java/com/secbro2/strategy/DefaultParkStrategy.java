package com.secbro2.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 提供一个默认，通用的计算实现
 **/
@Slf4j
@Service("defaultParkStrategy")
public class DefaultParkStrategy extends AbstractParkStrategy {

	@Override
	public int calcDistance(int count) {
		log.info("处理【通用公园】距离计算：count={}", count);
		// 默认 20米
		return 20 * count;
	}

}
