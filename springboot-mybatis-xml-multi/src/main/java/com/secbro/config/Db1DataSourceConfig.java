package com.secbro.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/1 6:09 PM
 **/
@Configuration
@MapperScan(basePackages = "com.secbro.mapper.db1", sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class Db1DataSourceConfig {

	@Primary
	@Bean(name = "db1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	public DataSource db1DataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "db1SqlSessionFactory")
	@Primary
	public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/db1/*" +
				".xml"));
		return bean.getObject();
	}

	@Bean(name = "db1SqlSessionTemplate")
	@Primary
	public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	/**
	 * 将数据源添加到事务中
	 */
	@Bean(name = "db1TransactionManager")
	@Primary
	public DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
