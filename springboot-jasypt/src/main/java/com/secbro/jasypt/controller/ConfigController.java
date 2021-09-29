package com.secbro.jasypt.controller;

import com.secbro.jasypt.conf.ConfigProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2021/9/28
 **/
@RestController
@RequestMapping("/")
public class ConfigController {

	@Resource
	private ConfigProperties configProperties;

	@RequestMapping
	public void print(){
		System.out.println(configProperties.getUrl());
		System.out.println(configProperties.getPassword());
	}
}
