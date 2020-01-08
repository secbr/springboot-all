package com.secbro2.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 手机号校验
 * @author zzs
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {

	/**
	 * 错误提示
	 */
	String message() default "手机号格式错误";

	/**
	 * 分组校验
	 */
	Class<?>[] groups() default {};


	Class<? extends Payload>[] payload() default {};

}
