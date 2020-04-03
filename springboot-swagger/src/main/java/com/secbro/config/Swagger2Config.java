package com.secbro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/24 10:09 AM
 **/
@Configuration
@EnableSwagger2
@Profile({"dev","test"})
public class Swagger2Config {

	@Value("${swagger.isShow}")
	private boolean isShow;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.enable(isShow)
				.apiInfo(apiInfo())
				// 返回ApiSelectorBuilder实例，用来控制对哪些接口进行展现
				.select()
				// 扫描需要生成API文档的controller所在的包路径
				.apis(RequestHandlerSelectors.basePackage("com.secbro.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring Boot 2.x集成Swagger")
				.description("用户管理 API 1.0 操作文档")
				.termsOfServiceUrl("http://www.choupangxia.com/")
				.version("1.0")
				.contact(new Contact("程序新视界", "http://www.choupangxia.com/", "secbro2@gmail.com"))
				.build();
	}
}
