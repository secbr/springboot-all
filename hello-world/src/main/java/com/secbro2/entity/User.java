package com.secbro2.entity;

import com.secbro2.annotation.InitSex;
import com.secbro2.annotation.ValidateAge;

/**
 * @author zzs
 */
public class User {

	private String username;

	@ValidateAge(min = 20, max = 35, value = 22)
	private int age;

	@InitSex(sex = InitSex.SEX_TYPE.MAN)
	private String sex;

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
}
