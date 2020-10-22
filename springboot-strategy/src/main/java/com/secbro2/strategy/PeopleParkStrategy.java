package com.secbro2.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 人民公园的实现
 **/
@Slf4j
@Service("peopleParkStrategy")
public class PeopleParkStrategy extends AbstractParkStrategy {

	@Override
	public int calcDistance(int count) {
		log.info("处理【人民公园】距离计算：count={}", count);
		// 默认 10米
		return 10 * count;
	}

}
