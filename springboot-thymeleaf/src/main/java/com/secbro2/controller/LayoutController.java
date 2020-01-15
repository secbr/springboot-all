package com.secbro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/15 6:44 AM
 **/
@Controller
public class LayoutController {

	@GetMapping("index")
	public String layout(){

		return "index";
	}
}
