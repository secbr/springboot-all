package com.secbro2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/6 10:02 AM
 **/
@RestController
public class HttpsController {

	@RequestMapping("/")
	public String hello(){

		return "Hello Spring-Boot-Https!";
	}
}
