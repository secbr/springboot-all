package com.secbro2.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zzs
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@ComponentScan(basePackages = "com.secbro2.controller")
//@ComponentScan(resourcePattern = "../**/*.class")
public class SpringbootRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRunApplication.class, args);
	}

}
