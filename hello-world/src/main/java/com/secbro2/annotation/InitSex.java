package com.secbro2.annotation;

import java.lang.annotation.*;

/**
 * 性别赋值
 * @author zzs
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Inherited
public @interface InitSex {

	/**
	 * sex enum
	 * @author zzs
	 */
	enum SEX_TYPE {MAN, WOMAN}

	SEX_TYPE sex() default SEX_TYPE.MAN;


}
