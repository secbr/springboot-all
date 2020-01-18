package com.secbro2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/17 10:52 AM
 **/
@Controller
public class SpringMvcController {

	@RequestMapping("/")
	public String hello(Model model){

		model.addAttribute("name","Tom");

		return "index";
	}

	@RequestMapping("/helloWorld")
	public ModelAndView helloWorld(){

		ModelAndView mv = new ModelAndView("helloWorld");
		mv.addObject("name","Tom");

		return mv;
	}
}
