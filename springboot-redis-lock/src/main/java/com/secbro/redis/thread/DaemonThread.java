package com.secbro.redis.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Redis 守护线程
 *
 * @author sec
 * @version 1.0
 * @date 2021/10/17
 **/
public class DaemonThread implements Runnable {
	private final static Logger logger = LoggerFactory.getLogger(DaemonThread.class);

	// 是否需要守护 主线程关闭则结束守护线程
	private volatile boolean daemon = true;
	// 守护锁
	private String lockKey;

	private RedisTemplate<Object, Object> redisTemplate;


	public DaemonThread(String lockKey, RedisTemplate<Object, Object> redisTemplate) {
		this.lockKey = lockKey;
		this.redisTemplate = redisTemplate;
	}


	@Override
	public void run() {
		try {
			while (daemon) {
				long time = redisTemplate.getExpire(lockKey, TimeUnit.MILLISECONDS);
				// 剩余有效期小于1秒则续命
				if (time < 1000) {
					logger.info("守护进程: " + Thread.currentThread().getName() + " 延长锁时间 5000 毫秒");
					redisTemplate.expire(lockKey, 5000, TimeUnit.MILLISECONDS);
				}
				TimeUnit.MILLISECONDS.sleep(300);
			}
			logger.info(" 守护进程: " + Thread.currentThread().getName() + "关闭 ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 主线程主动调用结束
	public void stop() {
		daemon = false;
	}
}
