package com.choupangxia.controller;

import com.choupangxia.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/31 10:10 AM
 **/
@RestController
public class JsonController {

	@GetMapping("userInfo")
	public User getUserInfo() {

		User user = new User();
		user.setUserNo("1000");
		user.setUsername("Tom");
		user.setAge(18);
		user.setCreateDate(new Date());

		return user;
	}

	@PostMapping("/addUser")
	public void addUser(@RequestBody User user) {

		System.out.println("userNo: " + user.getUserNo());
		System.out.println("username: " + user.getUsername());
		System.out.println("age: " + user.getAge());
		System.out.println("createDate: " + user.getCreateDate());

	}
}
