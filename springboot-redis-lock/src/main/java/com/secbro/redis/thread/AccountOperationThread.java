package com.secbro.redis.thread;

import com.secbro.redis.entity.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 账户操作,多线程方式模拟分布式环境
 *
 * @author sec
 * @version 1.0
 * @date 2021/10/17
 **/
public class AccountOperationThread implements Runnable {

	private final static Logger logger = LoggerFactory.getLogger(AccountOperationThread.class);

	private static final Long RELEASE_SUCCESS = 1L;

	private String userId;

	private RedisTemplate<Object, Object> redisTemplate;

	private DefaultRedisScript<Boolean> lockRedisScript;

	private DefaultRedisScript<Long> unlockRedisScript;

	public AccountOperationThread(String userId, RedisTemplate<Object, Object> redisTemplate,
	                              DefaultRedisScript<Boolean> lockRedisScript,
	                              DefaultRedisScript<Long> unlockRedisScript) {
		this.userId = userId;
		this.redisTemplate = redisTemplate;
		this.lockRedisScript = lockRedisScript;
		this.unlockRedisScript = unlockRedisScript;
	}

	@Override
	public void run() {
		// 不做任何同步
		noLock();
		// 基于Redis锁
//		redisLock();
//		atomicityRedisLock();
		// 解决死锁问题
//		deadLock();

//		atomicityAndExRedisLock();

//		deamonRedisLock();

//		deamonRedisLockWithLua();

	}


	/**
	 * 不做任何同步（锁）
	 */
	private void noLock() {
		try {
			Random random = new Random();
			// 为了更好测试，模拟线程先后进入，每个线程随机休眠 1-100毫秒再进行业务操作
			TimeUnit.MILLISECONDS.sleep(random.nextInt(100) + 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//模拟数据库中获取用户账号
		UserAccount userAccount = (UserAccount) redisTemplate.opsForValue().get(userId);
		//设置金额
		userAccount.addAmount(1);
		logger.info(Thread.currentThread().getName() + " : user id : " + userId + " amount : " + userAccount.getAmount());
		//模拟存回数据库
		redisTemplate.opsForValue().set(userId, userAccount);
	}

	/**
	 * 1.抢占资源时判断是否被锁。
	 * 2.如未锁则抢占成功且加锁，否则等待锁释放。
	 * 3.业务完成后释放锁,让给其它线程。
	 * <p>
	 * 该方案并未解决同步问题，原因：线程获得锁和加锁的过程，并非原子性操作，可能会导致线程A获得锁，还未加锁时，线程B也获得了锁。
	 */
	private void redisLock() {
		Random random = new Random();
		try {
			//为了更好测试，模拟线程进入间隔，每个线程随机休眠 1-1000毫秒再进行业务操作
			TimeUnit.MILLISECONDS.sleep(random.nextInt(1000) + 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {
			Object lock = redisTemplate.opsForValue().get(userId + ":syn");
			if (lock == null) {
				// 获得锁 -> 加锁 -> 跳出循环
				logger.info(Thread.currentThread().getName() + ":获得锁");
				redisTemplate.opsForValue().set(userId + ":syn", "lock");
				break;
			}
			try {
				// 等待500毫秒重试获得锁
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			//模拟数据库中获取用户账号
			UserAccount userAccount = (UserAccount) redisTemplate.opsForValue().get(userId);
			if (userAccount != null) {
				//设置金额
				userAccount.addAmount(1);
				logger.info(Thread.currentThread().getName() + " : user id : " + userId + " amount : " + userAccount.getAmount());
				//模拟存回数据库
				redisTemplate.opsForValue().set(userId, userAccount);
			}
		} finally {
			//释放锁
			redisTemplate.delete(userId + ":syn");
			logger.info(Thread.currentThread().getName() + ":释放锁");
		}
	}

	/**
	 * 1.原子操作加锁
	 * 2.竞争线程循环重试获得锁
	 * 3.业务完成释放锁
	 */
	private void atomicityRedisLock() {
		//Spring data redis 支持的原子性操作
		while (!redisTemplate.opsForValue().setIfAbsent(userId + ":syn", "lock")) {
			try {
				// 等待100毫秒重试获得锁
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info(Thread.currentThread().getName() + ":获得锁");
		try {
			//模拟数据库中获取用户账号
			UserAccount userAccount = (UserAccount) redisTemplate.opsForValue().get(userId);
			if (userAccount != null) {
				//设置金额
				userAccount.addAmount(1);
				logger.info(Thread.currentThread().getName() + " : user id : " + userId + " amount : " + userAccount.getAmount());
				//模拟存回数据库
				redisTemplate.opsForValue().set(userId, userAccount);
			}
		} finally {
			//释放锁
			redisTemplate.delete(userId + ":syn");
			logger.info(Thread.currentThread().getName() + ":释放锁");
		}
	}

	/**
	 * 1. 线程1 拿到锁
	 * 2. 业务执行到一半宕机
	 * 3. 无法正常释放锁
	 * 4. 其它线程竞争资源导致死锁
	 */
	private void deadLock() {
		//Spring data redis 支持的原子性操作
		while (!redisTemplate.opsForValue().setIfAbsent(userId + ":syn", "lock")) {
			try {
				// 等待1000毫秒重试获得锁
				logger.info(Thread.currentThread().getName() + ":尝试循环获取锁");
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info(Thread.currentThread().getName() + ":获得锁");
		try {
			// 应用在这里宕机，进程退出，无法执行 finally;
			Thread.currentThread().interrupt();
			// 业务逻辑...
		} finally {
			//释放锁
			if (!Thread.currentThread().isInterrupted()) {
				redisTemplate.delete(userId + ":syn");
				logger.info(Thread.currentThread().getName() + ":释放锁");
			}
		}
	}

	/**
	 * 1. 原子操作，获得锁并设置5秒过期时间
	 * 2. 业务执行到一半宕机
	 * 3. 无法正常释放锁
	 * 4. 其它线程等待过期时间获得锁
	 */
	private void atomicityAndExRedisLock() {
		try {
			//Spring data redis 支持的原子性操作,并设置5秒过期时间
			while (!redisTemplate.opsForValue().setIfAbsent(userId + ":syn",
					System.currentTimeMillis() + 5000, 5000, TimeUnit.MILLISECONDS)) {
				// 等待100毫秒重试获得锁
				logger.info(Thread.currentThread().getName() + ":尝试循环获取锁");
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			logger.info(Thread.currentThread().getName() + ":获得锁--------");
			// 应用在这里宕机，进程退出，无法执行 finally;
			Thread.currentThread().interrupt();
			// 业务逻辑...
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//释放锁
			if (!Thread.currentThread().isInterrupted()) {
				redisTemplate.delete(userId + ":syn");
				logger.info(Thread.currentThread().getName() + ":释放锁");
			}
		}
	}


	/**
	 * 1. 原子操作，获得锁并设置5秒过期时间
	 * 2. 获取锁并且开启守护线程
	 * 3. 业务执行时间超过5秒
	 * 4. 守护线程判断时间，快超时时为锁续命5秒
	 * 5. 主线程执行完毕，释放锁，释放守护线程
	 */
	private void deamonRedisLock() {
		//守护线程
		DaemonThread daemonThread = null;
		//Spring data redis 支持的原子性操作,并设置5秒过期时间
		String uuid = UUID.randomUUID().toString();
		String value = Thread.currentThread().getId() + ":" + uuid;
		try {
			while (!redisTemplate.opsForValue().setIfAbsent(userId + ":syn", value, 5000, TimeUnit.MILLISECONDS)) {
				// 等待100毫秒重试获得锁
				logger.info(Thread.currentThread().getName() + ":尝试循环获取锁");
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			logger.info(Thread.currentThread().getName() + ":获得锁----");
			// 开启守护线程
			daemonThread = new DaemonThread(userId + ":syn", redisTemplate);
			Thread thread = new Thread(daemonThread);
			thread.start();
			// 业务逻辑执行10秒...
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//释放锁 这里也需要原子操作,今后通过 Redis + Lua 讲
			String result = (String) redisTemplate.opsForValue().get(userId + ":syn");
			if (value.equals(result)) {
				redisTemplate.delete(userId + ":syn");
				logger.info(Thread.currentThread().getName() + ":释放锁-----");
			}
			//关闭守护线程
			if (daemonThread != null) {
				daemonThread.stop();
			}
		}
	}

	private void deamonRedisLockWithLua() {
		//守护线程
		DaemonThread daemonThread = null;
		//Spring data redis 支持的原子性操作,并设置5秒过期时间
		String uuid = UUID.randomUUID().toString();
		String value = Thread.currentThread().getId() + ":" + uuid;
		try {
//			boolean result = redisTemplate.execute(lockRedisScript, Collections.singletonList(userId + ":syn"), value,
//			5000);

			while (!redisTemplate.execute(lockRedisScript, Collections.singletonList(userId + ":syn"), value, 5)) {
				// 等待1000毫秒重试获得锁
				logger.info(Thread.currentThread().getName() + ":尝试循环获取锁");
				TimeUnit.MILLISECONDS.sleep(1000);
			}
			logger.info(Thread.currentThread().getName() + ":获得锁----");
			// 开启守护线程
			daemonThread = new DaemonThread(userId + ":syn", redisTemplate);
			Thread thread = new Thread(daemonThread);
			thread.start();
			// 业务逻辑执行10秒...
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e) {
			logger.error("异常", e);
		} finally {
			//使用Lua脚本：先判断是否是自己设置的锁，再执行删除
			// key存在,当前值=期望值时,删除key;key存在,当前值!=期望值时,返回0;
			Long result = redisTemplate.execute(unlockRedisScript, Collections.singletonList(userId + ":syn"), value);
			logger.info("redis解锁:{}", RELEASE_SUCCESS.equals(result));
			if (RELEASE_SUCCESS.equals(result)) {
				if (daemonThread != null) {
					//关闭守护线程
					daemonThread.stop();
					logger.info(Thread.currentThread().getName() + ":释放锁---");
				}
			}
		}
	}
}
