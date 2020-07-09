package com.secbro2.utils;

//import com.ipu.common.exception.RRException;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * hibernate-validator校验工具类
 * <p>
 * 参考文档：http://docs.jboss.org/hibernate/validator/5.4/reference/en-US/html_single/
 *
 * @author Mark
 */
@Component
public class ValidatorUtils {

	private static Validator validator;

	public ValidatorUtils(LocalValidatorFactoryBean localValidatorFactoryBean) {
		if (localValidatorFactoryBean != null) {
			validator = localValidatorFactoryBean.getValidator();
		}
	}

	/**
	 * 校验对象
	 *
	 * @param object 待校验对象
	 * @param groups 待校验的组
	 * 校验不通过，则报RRException异常
	 */
	public static void validateEntity(Object object, Class<?>... groups){
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			ConstraintViolation<Object> constraint = constraintViolations.iterator().next();
//			throw new RRException(constraint.getMessage());
		}
	}
}
