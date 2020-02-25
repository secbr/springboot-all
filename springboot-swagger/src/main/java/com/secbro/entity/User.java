package com.secbro.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/19 10:32 AM
 **/
@Data
@ApiModel(value = "用户实体类",description = "用户信息，用户接受、返回参数")
public class User {

	@ApiModelProperty(value = "用户ID", name = "id", example = "0")
	private Long id;

	@ApiModelProperty(value = "用户名",name = "username",example = "Tom")
	private String username;
}
