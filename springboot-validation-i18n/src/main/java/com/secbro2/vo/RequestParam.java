package com.secbro2.vo;

import com.secbro2.utils.In;

import javax.validation.constraints.Max;

/**
 * @author sec
 * @version 1.0
 * @date 2020/7/9 9:36 上午
 **/
public class RequestParam {

	private String username;

	@Max(value = 60, message = "最大岁数不超过{value}岁")
	private int age;

	@In(values = {1, 2})
	private Integer type;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
