package com.secbro2.config;

import com.secbro2.conditional.MysqlCondition;
import com.secbro2.conditional.OracleCondition;
import com.secbro2.db.DbConfigBean;
import com.secbro2.db.MysqlDbConfigBean;
import com.secbro2.db.OracleDbConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/26 3:52 PM
 **/
@Configuration
public class DbConfig {

	@Primary
	@Bean
	@Conditional(MysqlCondition.class)
	public DbConfigBean mysql() {
		return new MysqlDbConfigBean();
	}

	@Bean
	@Conditional(OracleCondition.class)
	public DbConfigBean oracle() {
		return new OracleDbConfigBean();
	}


}
