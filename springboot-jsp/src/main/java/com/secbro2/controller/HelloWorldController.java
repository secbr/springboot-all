package com.secbro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/9 3:55 PM
 **/
@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public String hello(String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

}
