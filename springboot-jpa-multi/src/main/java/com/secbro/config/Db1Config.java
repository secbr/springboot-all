package com.secbro.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/5 8:57 AM
 **/
@Configuration
@EnableJpaRepositories(
		entityManagerFactoryRef="db1EntityManagerFactory",
		transactionManagerRef="db1TransactionManager",
		basePackages= { "com.secbro.dao.db1" }) //设置dao（repo）所在位置
public class Db1Config {

	@Bean(name = "db1DataSource")
	@Primary
	@ConfigurationProperties("spring.datasource.db1")
	public DataSource db1DataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 获取主库实体管理工厂对象
	 *
	 * @param db1DataSource       注入名为db1DataSource的数据源
	 * @param jpaProperties       注入名为jpaProperties的jpa配置信息
	 * @param hibernateProperties 注入名为hibernateProperties配置信息
	 * @param builder             注入EntityManagerFactoryBuilder
	 * @return 实体管理工厂对象
	 */
	@Primary
	@Bean(name = "db1EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean db1EntityManagerFactory(@Qualifier("db1DataSource") DataSource db1DataSource
			, JpaProperties jpaProperties, HibernateProperties hibernateProperties, EntityManagerFactoryBuilder builder) {
		return builder
				// 设置数据源
				.dataSource(db1DataSource)
				// 设置jpa配置
				.properties(jpaProperties.getProperties())
				// 设置hibernate配置
				.properties(hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(),
						new HibernateSettings()))
				// 设置实体包名
				.packages("com.secbro.model")
				// 设置持久化单元名，用于@PersistenceContext注解获取EntityManager时指定数据源
				.persistenceUnit("db1PersistenceUnit")
				.build();
	}

	/**
	 * 获取实体管理对象
	 *
	 * @param factory 注入名为db1EntityManagerFactory的bean
	 * @return 实体管理对象
	 */
	/*@Primary
	@Bean(name = "db1EntityManager")
	public EntityManager db1EntityManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory factory) {
		return factory.createEntityManager();
	}*/

	/**
	 * 获取事务管理对象
	 *
	 * @param factory 注入名为db1EntityManagerFactory的bean
	 * @return 事务管理对象
	 */
	@Primary
	@Bean(name = "db1TransactionManager")
	public PlatformTransactionManager db1TransactionManager(@Qualifier("db1EntityManagerFactory") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}


}
