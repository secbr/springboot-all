package com.secbro2.controller;

import com.secbro2.util.MessageUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/28 4:37 PM
 **/
@RestController
@RequestMapping("/i18n")
public class I18nController {

	@RequestMapping("/user")
	public String getUserName() {
		return MessageUtils.get("username");
	}
}
