package com.secbro2.controller;

import com.secbro2.vo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/28 4:37 PM
 **/
@RestController
public class PostmanController {


	@PostMapping("login")
	public Result login(String username, String password) {

		System.out.println("username:" + username);
		System.out.println("password:" + password);

		Result result = new Result();
		result.setCode(0);
		result.setDesc("success");
		return result;
	}

}
