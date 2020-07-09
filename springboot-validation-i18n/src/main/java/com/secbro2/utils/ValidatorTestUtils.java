package com.secbro2.utils;

import com.secbro2.vo.RequestParam;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author sec
 * @version 1.0
 * @date 2020/7/9 9:44 上午
 **/
public class ValidatorTestUtils {

	private static Validator validator;

	static {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	/**
	 * 校验对象
	 *
	 * @param object 待校验对象
	 * @param groups 待校验的组
	 */
	public static void validateEntity(Object object, Class<?>... groups) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			ConstraintViolation<Object> constraint = constraintViolations.iterator().next();
			System.out.println(constraint.getMessage());
		}
	}

	public static void main(String[] args) {
		RequestParam param = new RequestParam();
		param.setUsername("zhangsan");
		param.setAge(50);
		param.setType(3);
		ValidatorTestUtils.validateEntity(param);
	}

}
