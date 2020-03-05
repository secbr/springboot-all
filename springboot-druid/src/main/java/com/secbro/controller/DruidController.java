package com.secbro.controller;

import com.secbro.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/5 11:41 AM
 **/
@RestController
public class DruidController {

	@Resource
	private OrderService orderService;


	@GetMapping("/")
	public String hello(){
		orderService.findAll();

		return "Hello Druid";
	}

}
