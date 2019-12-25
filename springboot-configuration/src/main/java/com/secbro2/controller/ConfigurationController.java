package com.secbro2.controller;

import com.secbro2.entity.RemoteConfig;
import com.secbro2.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/25 4:49 PM
 **/
@RestController
public class ConfigurationController {

	@Resource
	private RemoteConfig remoteConfig;

	@Resource
	private User user;

	@GetMapping
	public void getInfo() {

		System.out.println("地址：" + remoteConfig.getAddress());
		System.out.println("端口：" + remoteConfig.getPort());
		System.out.println("用户名：" + remoteConfig.getUser().getUsername());

	}

	@GetMapping("/user")
	public void getUser(){
		System.out.println("用户名：" + user.getUsername());
		System.out.println("密码：" + user.getPassword());
		System.out.println("姓名：" + user.getFirstName());
	}
}
