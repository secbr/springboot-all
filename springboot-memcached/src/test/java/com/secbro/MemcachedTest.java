package com.secbro;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/24 10:47 上午
 **/
@Slf4j
@SpringBootTest
public class MemcachedTest {

	@Autowired
	private MemcachedClient memcachedClient;

	@Test
	public void testAddAndGet() throws Exception {
		// 添加缓存
		memcachedClient.set("wechat", 0, "公众号：程序新视界");

		// 获取缓存
		String value = memcachedClient.get("wechat");
		System.out.println("wechat=" + value);

		// 删除缓存
		memcachedClient.delete("wechat");
	}


}