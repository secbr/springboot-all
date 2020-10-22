package com.secbro2.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 北海公园的实现
 **/
@Slf4j
@Service("beiHaiParkStrategy")
public class BeiHaiParkStrategy extends AbstractParkStrategy {

	@Override
	public int calcDistance(int count) {
		log.info("处理【北海公园】距离计算：count={}", count);
		// 默认 10米
		return 50 * count;
	}

}
