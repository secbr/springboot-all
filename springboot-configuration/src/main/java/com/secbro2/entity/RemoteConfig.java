package com.secbro2.entity;

import com.secbro2.factory.YamlPropertyLoaderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author sec
 * @version 1.0
 * @date 2019/12/25 4:46 PM
 **/
@Component
@PropertySource(value = "classpath:remote.yml",factory = YamlPropertyLoaderFactory.class)
//@PropertySource({"classpath:remote.properties"})
@ConfigurationProperties(prefix = "remote")
@Validated
public class RemoteConfig {

	/**
	 * 远程服务地址
	 */
	private String address;

	/**
	 * 远程服务端口
	 */
	private int port;

//	@NotNull
	private String phone;

	private User user;


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
