package com.secbro2.controller;

import com.secbro2.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2021/7/12
 **/
@Controller
public class TestController {

	@Resource
	private UserService userService;
}
