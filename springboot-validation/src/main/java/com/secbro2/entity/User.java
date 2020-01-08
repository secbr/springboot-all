package com.secbro2.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/8 7:11 PM
 **/
@Data
public class User {

	@NotEmpty(groups = BaseUser.class, message = "用户名不能为空")
	private String username;

	@NotEmpty(groups = DetailUser.class, message = "用户详情不能为空")
	private String userDetail;

	public interface BaseUser {
	}

	public interface DetailUser {
	}

}
