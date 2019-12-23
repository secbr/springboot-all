package com.secbro2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/23 10:28 AM
 **/
@RestController
public class ProfileController {

	@Value("${user.username}")
	private String username;

	@Value("${user.phone}")
	private String phone;

	@GetMapping
	public String getInfo() {

		return "username=" + username + ";phone=" + phone;
	}
}
