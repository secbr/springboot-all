package com.secbro2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzs
 */
@Slf4j
@RestController
public class HelloWorldController {

	@RequestMapping("/hello")
	public void hello() {
		log.debug("Hello world 测试debug日志");
		log.info("Hello world 测试info日志");
		log.warn("Hello world 测试warn日志");
		log.error("Hello world 测试error日志");
	}
}
