package com.choupangxia.entity;

import com.choupangxia.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/1 10:31 PM
 **/
@JsonNaming(PropertyNamingStrategy.LowerDotCaseStrategy.class)
public class UserDetail {

	@JsonView(View.BaseView.class)
	private String userNo;

	@JsonView(View.BaseView.class)
	private String username;

	@JsonView(View.DetailView.class)
	private String address;

	@JsonView(View.DetailView.class)
	private String email;


	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
