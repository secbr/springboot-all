package com.secbro2.config;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/7 9:30 AM
 **/
@ControllerAdvice
public class ExceptionConfig {


	@ResponseBody
	@ExceptionHandler(Exception.class)
	public Map<String, String> customException(Exception e) {

		Map<String, String> map = new HashMap<>();
		map.put("code", "error");
		map.put("msg", e.getMessage());
		return map;
	}

	@ModelAttribute(name = "version")
	public String version() {
		return "1.0";
	}

	@ModelAttribute
	public void version(Model model) {
		model.addAttribute("device", "IOS");
	}

	@InitBinder
	public void handleException(WebDataBinder binder) {
		binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
	}

}
