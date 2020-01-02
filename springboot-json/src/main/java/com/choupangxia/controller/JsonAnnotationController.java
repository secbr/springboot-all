package com.choupangxia.controller;

import com.choupangxia.entity.LoginUser;
import com.choupangxia.entity.User;
import com.choupangxia.entity.UserDetail;
import com.choupangxia.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/31 10:10 AM
 **/
@RestController
@RequestMapping("/annotation")
public class JsonAnnotationController {

	@GetMapping("userInfo")
	public LoginUser getUserInfo() {
		LoginUser user = new LoginUser();
		user.setUsername("15600000000");
		user.setPassword("123456");
		user.setLoginTime(new Date());

		return user;
	}

	@JsonView(View.DetailView.class)
	@GetMapping("getUserViewInfo")
	public UserDetail getUserViewInfo() {
		UserDetail user = new UserDetail();
		user.setUserNo("10000");
		user.setUsername("Tom");
		user.setAddress("Beijing");
		user.setEmail("124@qq.com");
		return user;
	}


}
