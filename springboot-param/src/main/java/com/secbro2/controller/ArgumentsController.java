package com.secbro2.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/22 4:13 PM
 **/
@RestController
public class ArgumentsController {

	@Resource
	private ApplicationArguments arguments;

	@GetMapping("/args")
	public String getArgs() {

		System.out.println("# 非选项参数数量: " + arguments.getNonOptionArgs().size());
		System.out.println("# 选项参数数量: " + arguments.getOptionNames().size());
		System.out.println("# 非选项参具参数:");
		arguments.getNonOptionArgs().forEach(System.out::println);

		System.out.println("# 选项参数具体参数:");
		arguments.getOptionNames().forEach(optionName -> {
			System.out.println("--" + optionName + "=" + arguments.getOptionValues(optionName));
		});

		return "success";

	}
}
