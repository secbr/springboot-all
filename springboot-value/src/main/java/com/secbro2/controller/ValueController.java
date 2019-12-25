package com.secbro2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/25 9:09 AM
 **/
@PropertySource("classpath:my.properties")
@RestController
public class ValueController {

	/**
	 * 获取位于application.properties中配置的属性
	 */
	@Value("${user.name}")
	private String name;

	/**
	 * 获取位于my.properties中的配置属性
	 */
	@Value("${user.password}")
	private String password;

	/**
	 * 注入数组（自动根据","分割）
	 */
	@Value("${tools}")
	private String[] toolArray;

	/**
	 * 注入列表形式（自动根据","分割）
	 */
	@Value("${tools}")
	private List<String> toolList;

	/**
	 * 注入普通字符串，相当于直接给属性默认值
	 */
	@Value("程序新视界")
	private String wechatSubscription;

	/**
	 *  注入操作系统属性
	 */
	@Value("#{systemProperties['os.name']}")
	private String systemPropertiesName;

	/**
	 * 注入表达式结果
	 */
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private double randomNumber;

	/**
	 * 注入其他Bean属性：注入config对象的属性tool
	 */
	@Value("#{config.tool}")
	private String tool;

	/**
	 * 注入列表形式（自动根据"|"分割）
	 */
	@Value("#{'${words}'.split('\\|')}")
	private List<String> numList;

	/**
	 * 注入文件资源
	 */
	@Value("classpath:config.xml")
	private Resource resourceFile;

	/**
	 * 注入URL资源
	 */
	@Value("http://www.choupangxia.com")
	private URL homePage;

	/**
	 * 如果属性中未配置ip，则使用默认值
	 */
	@Value("${ip:127.0.0.1}")
	private String ip;

	/**
	 * 如果系统属性中未获取到port的值，则使用8888。
	 */
	@Value("#{systemProperties['port']?:'8888'}")
	private String port;

	@GetMapping
	public void getValue(){
		System.out.println("wechatSubscription=" + wechatSubscription);
		System.out.println("systemPropertiesName=" + systemPropertiesName);
		System.out.println("randomNumber=" + randomNumber);
		System.out.println("tool=" + tool);
		System.out.println("toolArray=" + toolArray[0]);
		System.out.println("toolList=" + toolList);
		System.out.println("numList=" + numList);
		System.out.println("resourceFile=" + resourceFile.getFilename());
		System.out.println("homePage=" + homePage.getHost());

		System.out.println("ip=" + ip);
		System.out.println("port=" + port);
	}


}
