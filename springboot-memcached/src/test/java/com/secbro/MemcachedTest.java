package com.secbro;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeoutException;

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

	@Test
	public void testAdd() throws InterruptedException, MemcachedException, TimeoutException {
		// 先增加
		memcachedClient.set("wechat", 1, "公众号：程序新视界");

		Thread.sleep(2000);

		if (!memcachedClient.add("wechat", 0, "二师兄")) {
			System.out.println("(1)新增失败");
		}

		System.out.println((String) memcachedClient.get("wechat"));
//		memcachedClient.delete("wechat");
	}

	@Test
	public void testReplace() throws InterruptedException, MemcachedException, TimeoutException {
		memcachedClient.set("hello", 0, "Hello Memcached!");
		if(!memcachedClient.replace("hello", 0, "Hello Memcached!")){
			System.out.println("替换失败");
		}

		System.out.println((String) memcachedClient.get("hello"));
	}

	@Test
	public void testAppend() throws InterruptedException, MemcachedException, TimeoutException {
		memcachedClient.delete("hello");

		memcachedClient.set("hello", 0, "Memcached");

		memcachedClient.prepend("hello","Hello ");

		memcachedClient.append("hello", "!");

		System.out.println((String) memcachedClient.get("hello"));
	}


}