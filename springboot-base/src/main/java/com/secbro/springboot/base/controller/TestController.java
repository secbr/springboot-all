package com.secbro.springboot.base.controller;

import com.secbro.springboot.base.common.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2022/8/1
 **/
@Slf4j
@RestController
public class TestController {

	@RequestMapping("/calc")
	public ResponseInfo<String> calc(Integer id) {
		try {
			// 模拟异常业务代码
			int num = 1 / id;
			log.info("计算结果num={}", num);
			return ResponseInfo.success();
		} catch (Exception e) {
			return ResponseInfo.fail("系统异常，请联系管理员！");
		}
	}

	@RequestMapping("/calc1")
	public ResponseInfo<String> calc1(Integer id) {
		// 模拟异常业务代码
		int num = 1 / id;
		log.info("计算结果num={}", num);
		return ResponseInfo.success();
	}
}
