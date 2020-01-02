package com.choupangxia.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * 用于登录
 * @author sec
 * @version 1.0
 * @date 2020/1/1 9:58 PM
 **/
@JsonIgnoreProperties({"password","remark"})
public class LoginUser {

	@JsonProperty("phone")
	private String username;

	@JsonIgnore
	private String password;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginTime;

	private String remark;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
