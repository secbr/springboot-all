package com.secbro2.controller;

import com.secbro2.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/7 9:18 AM
 **/
@Controller
public class UserController {

	@ResponseBody
	@RequestMapping
	public User getUserInfo() {
		User user = new User();
		user.setUserId(1);
		user.setUsername("Tom");

		return user;
	}
}
