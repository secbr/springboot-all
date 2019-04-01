package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzs
 */
@RestController
public class HelloWorldController {

	@RequestMapping
	public String hello() {
		return "hello world!";
	}
}
