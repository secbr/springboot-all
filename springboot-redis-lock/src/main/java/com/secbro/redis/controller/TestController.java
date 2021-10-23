package com.secbro.redis.controller;

import com.secbro.redis.entity.UserAccount;
import com.secbro.redis.thread.AccountOperationThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author sec
 * @version 1.0
 * @date 2021/10/17
 **/
@RestController
public class TestController {

	private final static Logger logger = LoggerFactory.getLogger(TestController.class);

	private static ExecutorService executorService = Executors.newFixedThreadPool(5);

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Resource
	private DefaultRedisScript<Boolean> lockRedisScript;

	@Resource
	private DefaultRedisScript<Long> unlockRedisScript;

	@GetMapping("/test")
	public String test() throws InterruptedException {
		//设置用户user_001到 Redis,初始化账户金额为0.
		redisTemplate.opsForValue().set("user_001", new UserAccount("user_001", 0));
		//开启10个线程进行同步测试，每个线程为账户增加1元
		for (int i = 0; i < 10; i++) {
			logger.info("创建线程i=" + i);
			executorService.execute(new AccountOperationThread("user_001", redisTemplate, lockRedisScript,
					unlockRedisScript));
		}

		//休眠1秒等待线程跑完
		TimeUnit.MILLISECONDS.sleep(1000);
		//获得Redis中的user_001账户
		UserAccount userAccount = (UserAccount) redisTemplate.opsForValue().get("user_001");
		logger.info("user id : " + userAccount.getUserId() + " amount : " + userAccount.getAmount());
		return "success";
	}

	@GetMapping("/test1")
	public String test1() throws InterruptedException {
		String userId = "1";
		String value = "abc";

		Boolean b = redisTemplate.execute(lockRedisScript, Collections.singletonList(userId + ":syn2"), value, 5);
		logger.info("lock result=" + b + "");
		Thread.sleep(2000);

		b = redisTemplate.execute(lockRedisScript, Collections.singletonList(userId + ":syn2"), value, 5);
		logger.info("lock result=" + b + "");

		Long result = redisTemplate.execute(unlockRedisScript, Collections.singletonList(userId + ":syn1"), "def");
		logger.info("no key def=" + result + "");

		redisTemplate.opsForValue().set(userId + ":syn", "abc");

		result = redisTemplate.execute(unlockRedisScript, Collections.singletonList(userId + ":syn"), "def");
		logger.info("has key but not equals def=" + result + "");

		result = redisTemplate.execute(unlockRedisScript, Collections.singletonList(userId + ":syn"), value);
		logger.info("abc=" + result + "");

		return "success";
	}

}
