package com.secbro2.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Mysql条件判断
 * @author sec
 * @version 1.0
 * @date 2019/12/26 3:48 PM
 **/
public class MysqlCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String dbType = context.getEnvironment().getProperty("db.type");
		return "mysql".equalsIgnoreCase(dbType);
	}

}
