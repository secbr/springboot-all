package com.secbro2.entity;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/8 11:26 AM
 **/
@Data
public class Order {

	@NotEmpty(message = "请求流水号不能为空")
	private String requestNo;

	@Min(value = 1, message = "至少购买1件")
	@Max(value = 10, message = "最多不超过10件")
	private int amount;

	@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
	@NotBlank(message = "手机号码不能为空")
	private String phone;

	private String goodsName;

}
