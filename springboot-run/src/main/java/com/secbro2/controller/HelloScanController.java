package com.secbro2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzs
 */
@RestController
public class HelloScanController {

	@RequestMapping("/hello")
	public String hello(){

		return "hello component scan!";
	}
}
