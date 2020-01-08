package com.secbro2.valid;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/8 3:52 PM
 **/
public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public boolean isValid(String phone, ConstraintValidatorContext constraintValidatorContext) {

		if (!StringUtils.isEmpty(phone)) {
			// 禁用默认提示信息
			constraintValidatorContext.disableDefaultConstraintViolation();
			// 设置提示语
			constraintValidatorContext.buildConstraintViolationWithTemplate("手机号格式错误").addConstraintViolation();

			String regex = "^1(3|4|5|7|8)\\d{9}$";
			return phone.matches(regex);
		}
		return true;
	}
}
