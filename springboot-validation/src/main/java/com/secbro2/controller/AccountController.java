package com.secbro2.controller;

import com.secbro2.entity.User;
import com.secbro2.util.BizResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/9 9:05 AM
 **/
@Validated
@RestController
public class AccountController {


	@GetMapping("/getAmountByAccountNo")
	public String getAmountByAccountNo(@NotEmpty String accountNo) {
		return "1000.00";
	}

	@PostMapping(value = "/addUser")
	public BizResult addUser(@Validated(User.BaseUser.class) User user) {

		return new BizResult();
	}


}
