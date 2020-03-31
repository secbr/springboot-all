package com.secbro;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.GetsResponse;
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
		if (!memcachedClient.replace("hello", 0, "Hello Memcached!")) {
			System.out.println("替换失败");
		}

		System.out.println((String) memcachedClient.get("hello"));
	}

	@Test
	public void testAppend() throws InterruptedException, MemcachedException, TimeoutException {
		memcachedClient.delete("hello");

		memcachedClient.set("hello", 0, "Memcached");

		memcachedClient.prepend("hello", "Hello ");

		memcachedClient.append("hello", "!");

		System.out.println((String) memcachedClient.get("hello"));
	}

	/**
	 * incr和decr错误使用示例
	 */
	@Test
	public void testIncreaseError() throws InterruptedException, MemcachedException, TimeoutException {

		// 设置count初始化值为1
		String key = "visitCount";
		memcachedClient.delete(key);
		memcachedClient.set(key, 0, 1);
		System.out.println("初始化:" + memcachedClient.get(key));
		memcachedClient.incr(key, 5);
		System.out.println("加5之后:" + memcachedClient.get(key));
		memcachedClient.decr(key, 1);
		System.out.println("减1之后:" + memcachedClient.get(key));
	}

	/**
	 * incr和decr使用示例，功能类似于AtomicInteger，具有原子操作特性。
	 */
	@Test
	public void testIncrease() throws InterruptedException, MemcachedException, TimeoutException {

		// 设置count初始化值为1
		String key = "visitCountKey";
		memcachedClient.delete(key);

		memcachedClient.incr(key, 1, 1);
		System.out.println("初始化之后:" + memcachedClient.get(key));
		memcachedClient.incr(key, 5);
		System.out.println("加5之后:" + memcachedClient.get(key));
		memcachedClient.decr(key, 1);
		System.out.println("减1之后:" + memcachedClient.get(key));

		memcachedClient.decr(key, 6);
		System.out.println("减6之后:" + memcachedClient.get(key));
	}

	/**
	 * 封装了incr和decr，用于获取递增或递减数据。
	 * 示例场景：想获取一个按照顺序递增的数值
	 */
	@Test
	public void testCounter() throws InterruptedException, MemcachedException, TimeoutException {

		String key = "id";
		memcachedClient.delete(key);

		Counter counter = memcachedClient.getCounter(key, 0);
		long id = counter.incrementAndGet();
		System.out.println("id：" + id);

		id = counter.addAndGet(8);
		System.out.println("id：" + id);

		id = counter.decrementAndGet();
		System.out.println("id：" + id);
	}

	/**
	 * Memcached于1.2.4版本新增CAS(Check and Set)协议类同于Java并发的CAS(Compare and Swap)
	 */
	@Test
	public void testCas() throws InterruptedException, MemcachedException, TimeoutException {

		String key = "amount";
		memcachedClient.delete(key);

		// 初始化值
		memcachedClient.set(key, 0, 100);

		GetsResponse<Object> response = memcachedClient.gets(key);
		long cas = response.getCas();
		System.out.println("cas：" + cas);
		int value = (int) response.getValue();
		memcachedClient.cas(key, 0, 200, cas);

		System.out.println("amount：" + memcachedClient.get(key));

	}


}