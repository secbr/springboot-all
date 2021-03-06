package com.secbro;

import com.secbro.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/24 10:47 上午
 **/
@Slf4j
@SpringBootTest
public class SpringCacheTest {

	@Resource
	private ConfigService configService;

	@Test
	public void testCacheable3() {
		int count = configService.getInt(2);
		log.info("---第1次获取完毕int={}", count);
		count = configService.getInt(2);
		log.info("---第2次获取完毕int={}", count);
		configService.addInt(2);

		count = configService.getInt(2);
		log.info("---第3次获取完毕int={}", count);

	}

	@Test
	public void testCacheable4() {
		int count = configService.getInt(1);
		log.info("---第1次获取完毕int={}", count);
		count = configService.getInt(1);
		log.info("---第2次获取完毕int={}", count);
		configService.clearInt();

		count = configService.getInt(1);
		log.info("---第3次获取完毕int={}", count);
	}
}