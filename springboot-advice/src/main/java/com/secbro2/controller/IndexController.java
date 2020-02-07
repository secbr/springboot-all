package com.secbro2.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/7 9:34 AM
 **/
@RestController
public class IndexController {

	@RequestMapping("/")
	public String index(String name) {

		if (name == null) {
			throw new RuntimeException("name is null");
		}
		return "Hello Exception!";
	}

	@RequestMapping("version")
	public Map<String,Object> getVersion(Model model) {
		Map<String,Object> map = new HashMap<>();
		map.put("version",model.getAttribute("version"));
		map.put("device",model.getAttribute("device"));
		return map;
	}

	@RequestMapping("addInfo")
	public void addInfo(Date birthTime){
		System.out.println("birthTime:" + birthTime);
	}

}
