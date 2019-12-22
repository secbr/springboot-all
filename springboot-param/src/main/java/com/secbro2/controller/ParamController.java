package com.secbro2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/22 12:20 PM
 **/
@RestController
public class ParamController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/param")
	public String param() {

		String systemServerPort = System.getProperty("server.port");

		System.out.println("@Value获得的serverPort：" + serverPort);
		System.out.println("System获得的serverPort：" + systemServerPort);

		return "success";
	}
}
