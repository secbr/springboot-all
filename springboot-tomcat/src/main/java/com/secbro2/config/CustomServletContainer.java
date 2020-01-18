package com.secbro2.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/18 10:04 AM
 **/
@Component
public class CustomServletContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
//		factory.setPort(8888);

		Set<ErrorPage> errorPages = new HashSet<>();
		ErrorPage errorPage = new ErrorPage("/error");
		errorPages.add(errorPage);
		factory.setErrorPages(errorPages);
	}
}
