package com.secbro2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzs
 */
@RestController
public class ConfigController {


	@RequestMapping("/config")
	public String config(){
		return "Hello World!" ;
	}

}
