package com.secbro2.health;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * @author sec
 * @version 1.0
 * @date 2021/7/12
 **/
@Component
@Endpoint(id = "my")
public class EndpointCustom {

	@ReadOperation
	public String endpointCustomRead(String content) {
		return "请求的内容: " + content;
	}

	@WriteOperation
	public String endpointCustomWrite(String content) {
		return "写的内容: " + content;
	}

	@DeleteOperation
	public String endpointCustomDelete(String content) {
		return "删除的内容: " + content;
	}

}
