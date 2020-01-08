package com.secbro2.controller;

import com.secbro2.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/8 7:12 PM
 **/
@Slf4j
@RestController
public class UserController {

	@PostMapping("/saveUser")
	public void saveUser(@Validated(User.BaseUser.class) User user, BindingResult result) {
		if (result.hasErrors()) {
			result.getAllErrors().forEach((error) -> {
				log.info(error.getCode() + "-" + error.getDefaultMessage());
			});
		}
	}

	@PostMapping("/saveUserDetail")
	public void saveUserDetail(@Validated(User.DetailUser.class) User user, BindingResult result) {
		if (result.hasErrors()) {
			result.getAllErrors().forEach((error) -> {
				log.info(error.getCode() + "-" + error.getDefaultMessage());
			});
		}
	}
}
