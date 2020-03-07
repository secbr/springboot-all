package com.secbro.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/7 9:55 AM
 **/
@Controller
public class IndexController {

	@RequestMapping
	public String index(Model model) {
		model.addAttribute("name", "Tom1");
		System.out.println(111);
		return "index";
	}
}
