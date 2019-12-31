package com.choupangxia.entity;

import java.util.Date;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/31 10:26 AM
 **/
public class User {

	private String userNo;

	private String username;

	private int age;

	/**
	 * 当前数据创建时间
	 */
	private Date createDate;


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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
