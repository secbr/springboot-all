package com.secbro2.controller;

import com.secbro2.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/8 11:30 AM
 **/
@Slf4j
@RestController
public class OrderController {

	@PostMapping("/buy")
	public void buy(@Valid Order order, BindingResult result) {

		log.info("请求order信息：{}", order);

		if (result.hasErrors()) {
			result.getAllErrors().forEach((error) -> {
				log.info(error.getCode() + "-" + error.getDefaultMessage());
			});
		}
	}
}
