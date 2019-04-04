package com.secbro2.annotation;

import java.lang.annotation.*;

/**
 * 年龄校验
 * @author zzs
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface ValidateAge {

	/**
	 * 最小值
	 */
	int min() default 18;

	/**
	 * 最大值
	 */
	int max() default 99;

	/**
	 * 默认值
	 */
	int value() default 20;

}
