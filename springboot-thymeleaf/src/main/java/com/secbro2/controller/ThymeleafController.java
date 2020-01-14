package com.secbro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/14 3:27 PM
 **/
@Controller
public class ThymeleafController {

	@RequestMapping("/base")
	public String base(Model model){

		model.addAttribute("name","Thymeleaf");

		model.addAttribute("isShow","true");

		List<String> languages = new ArrayList<>();
		languages.add("cn");
		languages.add("en");
		languages.add("ja");
		model.addAttribute("languages",languages);

		model.addAttribute("pageNum",1);

		model.addAttribute("id",1);

		model.addAttribute("date",new Date());

		return "base";

	}
}
