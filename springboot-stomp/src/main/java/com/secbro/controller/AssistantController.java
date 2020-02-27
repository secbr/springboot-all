package com.secbro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/19 10:17 AM
 **/
@Controller
public class AssistantController {

	private AtomicInteger idProducer = new AtomicInteger();

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("username","user" + idProducer.getAndIncrement());
		return "index";
	}

}
