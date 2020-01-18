package com.secbro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/18 10:27 AM
 **/
@Controller
public class HelloController {

	@RequestMapping
	public String hello(){
		return "hello";
	}

	/*@RequestMapping("/error")
	public String error(){
		return "error";
	}*/
}
