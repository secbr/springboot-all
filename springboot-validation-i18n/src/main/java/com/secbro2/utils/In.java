package com.secbro2.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author zzs
 */
@Constraint(validatedBy = InValidator.class)
@Target({java.lang.annotation.ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface In {

	String message() default "参数值不在指定范围内";

	int[] values() default {};

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
