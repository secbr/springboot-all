package com.secbro2.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/6 10:16 AM
 **/
@Configuration
public class HttpsConfig {

	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {

		// 手动实例化TomcatServletWebServerFactory对象并重写其postProcessContext方法
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory() {
			@Override
			protected void postProcessContext(Context context) {

				// 创建安全约束组件
				SecurityConstraint constraint = new SecurityConstraint();
				// 设置用户约束条件，参数必须以下三种模式：NONE、INTEGRAL、CONFIDENTIAL。
				// NONE表示被指定的Web资源不需要任何传输保证；
				// Integral表示客户机与服务器之间传送的数据在传送过程中不会被篡改；
				// Confidential表示数据在传送过程中被加密。
				// 大多数情况下，INTEGRAL或CONFIDENTIAL是使用SSL实现。
				constraint.setUserConstraint("CONFIDENTIAL");

				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};

		factory.addAdditionalTomcatConnectors(httpsConnector());
		return factory;
	}

	private Connector httpsConnector() {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		// Connector监听的http的端口号
		connector.setPort(8080);
		connector.setSecure(false);
		// 监听到http的端口号后转向到的https的端口号
		connector.setRedirectPort(8443);
		return connector;
	}
}
