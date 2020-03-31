package com.secbro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zzs
 */
@SpringBootApplication
@MapperScan("com.secbro.mapper")
public class SpringBootMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}

}
