package com.secbro.jasypt.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sec
 * @version 1.0
 * @date 2021/9/28
 **/
@Data
@Component
public class ConfigProperties {

	@Value("${conf.url}")
	private String url;

	@Value("${conf.password}")
	private String password;

}
