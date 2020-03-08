package com.secbro.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/7 9:55 AM
 **/
@RestController
public class IndexController {

	/**
	 * 设置值到Session中
	 */
	@RequestMapping("/setSession")
	public Map<String, String> setSession(HttpServletRequest request) {

		request.getSession().setAttribute("webSite", "https://www.choupangxia.com/");

		Map<String, String> map = new HashMap<>(1);
		map.put("url", request.getRequestURL().toString());
		return map;
	}

	/**
	 * 获取Session中的值
	 */
	@RequestMapping("/getSession")
	public Map<String, String> getSession(HttpServletRequest request) {
		Map<String, String> map = new HashMap<>(2);
		map.put("url", request.getRequestURL().toString());
		map.put("webSite", (String) request.getSession().getAttribute("webSite"));
		return map;
	}
}
