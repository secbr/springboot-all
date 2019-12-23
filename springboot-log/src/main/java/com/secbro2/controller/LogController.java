package com.secbro2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author sec
 * @version 1.0
 * @date 2019/12/23 3:58 PM
 **/
@RestController
public class LogController {

	private Logger logger = LoggerFactory.getLogger(LogController.class);

	@GetMapping
	public void printLog() {
		logger.debug("WEB-----debug日志");
		logger.info("WEB-----info日志");
	}
}
