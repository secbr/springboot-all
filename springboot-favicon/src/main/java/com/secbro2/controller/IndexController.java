package com.secbro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/1 7:43 PM
 **/
@Controller
public class IndexController {

	@RequestMapping
	public String index(){
		return "index";
	}
}
